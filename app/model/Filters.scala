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

package model

import play.api.libs.json.Json

sealed trait ApiFilter[+A]
case class Value[A](a: A) extends ApiFilter[A]
case object NoSubscriptions extends ApiFilter[Nothing]
case object AllUsers extends ApiFilter[Nothing]

case object ApiFilter extends ApiFilter[String] {
  def apply(value: Option[String]): ApiFilter[String] = {
    value match {
      case Some("ALL") | None => AllUsers
      case Some("NONE") => NoSubscriptions
      case Some(flt) => Value(flt)
    }
  }
}


case class DeveloperFilter(filter: String, pageNumber: Int, pageSize: Int)