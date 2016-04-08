/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package acceptance.specs

import java.net.URLEncoder

import acceptance.pages.{ApprovedPage, DashboardPage}
import acceptance.{BaseSpec, SignInSugar}
import com.github.tomakehurst.wiremock.client.WireMock._
import component.matchers.CustomMatchers
import org.scalatest.Matchers

class APIGatekeeperApprovedSpec  extends BaseSpec with SignInSugar with Matchers with CustomMatchers with MockDataSugar {

  feature("View approved application details") {

    scenario("View details for an application in production") {

      stubApplicationListAndDevelopers
      stubFor(get(urlEqualTo(s"/gatekeeper/application/$approvedApp1"))
        .willReturn(aResponse().withBody(approvedApplication("application description", true)).withStatus(200)))

      signInGatekeeper
      on(DashboardPage)
      clickOnLink(s"data-view-$approvedApp1")
      on(ApprovedPage(approvedApp1, "Application"))

      verifyText("data-status", "►Verified")
      clickOnLink("data-status")
      verifyText("data-summary", "The submitter has verified that they still have access to the email address associated with this application.")
      verifyText("data-description", "application description")
      assertApplicationDetails
     }

    scenario("View details for an application pending verification") {

      stubApplicationListAndDevelopers
      stubFor(get(urlEqualTo(s"/gatekeeper/application/$approvedApp1"))
        .willReturn(aResponse().withBody(approvedApplication("application description")).withStatus(200)))

      signInGatekeeper
      on(DashboardPage)
      clickOnLink(s"data-view-$approvedApp1")
      on(ApprovedPage(approvedApp1, "Application"))

      verifyText("data-status", "►Not Verified")
      clickOnLink("data-status")
      verifyText("data-summary", "The submitter has not verified that they still have access to the email address associated with this application.")
      verifyText("data-description", "application description")
      assertApplicationDetails
    }

    scenario("View details for an application with no description"){

      stubApplicationListAndDevelopers
      stubFor(get(urlEqualTo(s"/gatekeeper/application/$approvedApp1"))
        .willReturn(aResponse().withBody(approvedApplication()).withStatus(200)))

      signInGatekeeper
      on(DashboardPage)
      clickOnLink(s"data-view-$approvedApp1")
      on(ApprovedPage(approvedApp1, "Application"))

      verifyText("data-description", "No description added")
      assertApplicationDetails
    }
  }

  def stubApplicationListAndDevelopers() = {
    val encodedEmail = URLEncoder.encode(adminEmail, "UTF-8")
    val encodedAdminEmails = URLEncoder.encode(s"$adminEmail,$admin2Email", "UTF-8")
    val expectedAdmins = s"""[${administrator()},${administrator(admin2Email, "Admin", "McAdmin")}]""".stripMargin

    stubFor(get(urlEqualTo("/gatekeeper/applications"))
      .willReturn(aResponse().withBody(approvedApplications).withStatus(200)))

    stubFor(get(urlEqualTo(s"/developer?email=$encodedEmail"))
      .willReturn(aResponse().withBody(administrator()).withStatus(200)))

    stubFor(get(urlEqualTo(s"/developers?emails=$encodedAdminEmails"))
      .willReturn(aResponse().withBody(expectedAdmins).withStatus(200)))
  }

  def assertApplicationDetails() = {
    verifyText("data-submitter-name", s"$firstName $lastName")
    verifyText("data-submitter-email", adminEmail)
    tagName("tbody").element.text should containInOrder(List(s"$firstName $lastName $adminEmail", s"Admin McAdmin $admin2Email"))
    verifyText("data-submitted-on", "Submitted: 22 March 2016")
    verifyText("data-approved-on", "Approved: 05 April 2016")
    verifyText("data-approved-by", "Approved by: gatekeeper.username")
  }
}
