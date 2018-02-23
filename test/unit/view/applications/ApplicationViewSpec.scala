/*
 * Copyright 2018 HM Revenue & Customs
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

package unit.view.applications

import java.util.UUID

import config.AppConfig
import model._
import org.joda.time.DateTime
import org.scalatestplus.play.{OneServerPerSuite, PlaySpec}
import play.api.mvc.Flash
import play.api.i18n.Messages.Implicits._
import play.api.test.FakeRequest

class ApplicationViewSpec extends PlaySpec with OneServerPerSuite {
  "application view" must {
    "show application information, including Delete Application button, when logged in as superuser" in {
      implicit val request = FakeRequest()
      val application =
        ApplicationResponse(
          UUID.randomUUID(),
          "application1",
          None,
          Set(Collaborator("sample@email.com", CollaboratorRole.ADMINISTRATOR), Collaborator("someone@email.com", CollaboratorRole.DEVELOPER)),
          DateTime.now(),
          Standard(),
          ApplicationState()
        )
      val applicationWithHistory = ApplicationWithHistory(application, Seq.empty)

      val result = views.html.applications.application.render(applicationWithHistory, Seq.empty, true, request, None, Flash.emptyCookie, applicationMessages, AppConfig)

      result.contentType must include("text/html")
      result.body must include("Delete Application")
    }
  }
}
