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

package acceptance.specs

import model.User
import org.scalacheck.Gen
import play.api.libs.json.Json

trait MockDataSugar {
  val appPendingApprovalId1 = "df0c32b6-bbb7-46eb-ba50-e6e5459162ff"
  val appPendingApprovalId2 = "a4b47c82-5888-41fd-aa83-da2bbd4679d1"
  val approvedApp1 = "df0c32b6-bbb7-46eb-ba50-e6e5459162ff"
  val approvedApp2 = "a4b47c82-5888-41fd-aa83-da2bbd4679d1"
  val approvedApp3 = "9688ad02-230e-42b7-8f9a-be593565bfdc"
  val approvedApp4 = "56148b28-65b0-47dd-a3ce-2f02840ddd31"
  val appToDelete = "fa38d130-7c8e-47d8-abc0-0374c7f73216"

  val applicationDescription = "application description"
  val adminEmail = "admin@example.com"
  val admin2Email = "admin2@example.com"
  val firstName = "John"
  val lastName = "Test"
  val fullName = s"$firstName $lastName"

  val developer = "purnima.fakename@example.com"
  val devFirstName = "Purnima"
  val devLastName = "Fakename"

  val developer2 = "imran.fakename@example.com"
  val dev2FirstName = "Imran"
  val dev2LastName = "Fakename"

  val developer3 = "gurpreet.fakename@example.com"
  val dev3FirstName = "Gurpreet"
  val dev3LastName =  "Fakename"

  val developer4 = "a.long.name.jane.hayjdjdu@a-very-long-email-address-exampleifi.com"
  val dev4FirstName = "HannahHmrcSdstusercollaboratir"
  val dev4LastName = "Kassidyhmrcdevusercollaborato"

  val developer5 = "John.fakename@example.com"
  val dev5FirstName = "John"
  val dev5LastName =  "Fakename"

  val developer6 = "Vijaya.fakename@example.com"
  val dev6FirstName = "Vijaya"
  val dev6LastName =  "Fakename"

  val developer7 = "Kerri.fakename@example.com"
  val dev7FirstName = "Kerri"
  val dev7LastName = "Fakename"

  val developer8 = "Dixie.fakename@example.com"
  val dev8FirstName = "Dixie"
  val dev8LastName = "Fakename"

  val developer9 = "fred@example.com"
  val dev9name = "n/a"

  val developer10 = "peter.fakename@example.com"
  val dev10name = "n/a"

  val randomEmail = s"john.smith${System.currentTimeMillis}@example.com"

  val statusVerified = "verified"
  val statusUnverified = "not yet verified"
  val statusUnregistered = "not registered"

  val applicationsPendingApproval =
    s"""
       |[
       |  {
       |    "id": "$appPendingApprovalId2",
       |    "clientId": "clientid1",
       |    "name": "Second Application",
       |    "submittedOn": 1458832690624,
       |    "state": "PENDING_GATEKEEPER_APPROVAL"
       |  },
       |  {
       |    "id": "$appPendingApprovalId1",
       |    "clientId": "clientid1",
       |    "name": "First Application",
       |    "submittedOn": 1458659208000,
       |    "state": "PENDING_GATEKEEPER_APPROVAL"
       |  },
       |  {
       |    "id": "9688ad02-230e-42b7-8f9a-be593565bfdc",
       |    "clientId": "clientid1",
       |    "name": "Third",
       |    "submittedOn": 1458831410657,
       |    "state": "PENDING_REQUESTER_VERIFICATION"
       |  },
       |  {
       |    "id": "56148b28-65b0-47dd-a3ce-2f02840ddd31",
       |    "clientId": "clientid1",
       |    "name": "Fourth",
       |    "submittedOn": 1458832728156,
       |    "state": "PRODUCTION"
       |  }
       |]
    """.stripMargin

  val approvedApplications =
    s"""
       |[
       |  {
       |    "id": "$approvedApp1",
       |    "clientId": "clientid1",
       |    "name": "Application",
       |    "submittedOn": 1458832690624,
       |    "state": "PENDING_REQUESTER_VERIFICATION"
       |  },
       |  {
       |    "id": "$approvedApp2",
       |    "clientId": "clientid2",
       |    "name": "ZApplication",
       |    "submittedOn": 1458659208000,
       |    "state": "PRODUCTION"
       |  },
       |  {
       |    "id": "$approvedApp3",
       |    "clientId": "clientid3",
       |    "name": "rapplication",
       |    "submittedOn": 1458831410657,
       |    "state": "PENDING_REQUESTER_VERIFICATION"
       |  },
       |  {
       |    "id": "$approvedApp4",
       |    "clientId": "clientid4",
       |    "name": "BApplication",
       |    "submittedOn": 1458832728156,
       |    "state": "PRODUCTION"
       |  }
       |]
    """.stripMargin

  val application =
    s"""
       |{
       |  "application": {
       |    "id": "$appPendingApprovalId1",
       |    "clientId": "clientid1",
       |    "name": "First Application",
       |    "description": "$applicationDescription",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "$adminEmail",
       |        "role": "ADMINISTRATOR"
       |      },
       |      {
       |        "emailAddress": "$developer",
       |        "role": "DEVELOPER"
       |      },
       |      {
       |        "emailAddress": "$developer8",
       |        "role": "DEVELOPER"
       |      }
       |    ],
       |    "createdOn": 1459866628433,
       |    "redirectUris": [],
       |    "termsAndConditionsUrl": "http://www.example.com/termsAndConditions",
       |    "privacyPolicyUrl": "http://www.example.com/privacy",
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "termsAndConditionsUrl": "http://localhost:22222/terms",
       |      "privacyPolicyUrl": "http://localhost:22222/privacy",
       |      "accessType": "STANDARD"
       |    },
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$adminEmail",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "checkInformation": {
       |      "contactDetails": {
       |        "fullname": "Holly Golightly",
       |        "email": "holly.golightly@example.com",
       |        "telephoneNumber": "020 1122 3344"
       |      },
       |      "confirmedName": true,
       |      "providedPrivacyPolicyURL": true,
       |      "providedTermsAndConditionsURL": true,
       |      "applicationDetails": "An application that is pending approval",
       |      "termsOfUseAgreements": [{
       |        "emailAddress": "test@example.com",
       |        "timeStamp": 1459868573962,
       |        "version": "1.0"
       |      }]
       |    },
       |    "approvedDetails": {
       |      "details": {
       |        "id": "",
       |        "clientId": "",
       |        "name": "",
       |        "description": "",
       |        "rateLimitTier": "BRONZE",
       |        "submission": {
       |          "submitterName": "Barry Dev hub",
       |          "submitterEmail": "barry.fakename@example.com",
       |          "submittedOn": 1459868573962
       |        },
       |        "reviewContactName": "Harry Golightly",
       |        "reviewContactEmail": "harry.fakename@example.com",
       |        "reviewContactTelephone": "020 1122 3345",
       |        "applicationDetails": ""
       |      },
       |      "admins": [],
       |      "approvedBy": "gatekeeperUserId",
       |      "approvedOn": 1459968573962,
       |      "verified": true
       |    }
       |  },
       |  "history": [
       |      {
       |      "applicationId": "a6d37b4a-0a80-4b7f-b150-5f8f99fe27ea",
       |      "state": "PENDING_GATEKEEPER_APPROVAL",
       |      "actor": {
       |        "id": "$adminEmail",
       |        "actorType": "COLLABORATOR"
       |      },
       |      "changedAt": 1458659208000
       |    },
       |    {
       |      "applicationId": "a6d37b4a-0a80-4b7f-b150-5f8f99fe27ea",
       |      "state": "PENDING_REQUESTER_VERIFICATION",
       |      "actor": {
       |        "id": "gatekeeper.username",
       |        "actorType": "GATEKEEPER"
       |      },
       |      "changedAt": 1459868522961
       |    }
       |  ]
       |}
    """.stripMargin

  val applicationToReview =
    s"""
       |{
       |  "application": {
       |    "id": "$appPendingApprovalId1",
       |    "clientId": "clientid1",
       |    "name": "First Application",
       |    "description": "$applicationDescription",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "$adminEmail",
       |        "role": "ADMINISTRATOR"
       |      },
       |      {
       |        "emailAddress": "$developer",
       |        "role": "DEVELOPER"
       |      },
       |      {
       |        "emailAddress": "$developer8",
       |        "role": "DEVELOPER"
       |      }
       |    ],
       |    "createdOn": 1459866628433,
       |    "redirectUris": [],
       |    "termsAndConditionsUrl": "http://www.example.com/termsAndConditions",
       |    "privacyPolicyUrl": "http://www.example.com/privacy",
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "termsAndConditionsUrl": "http://localhost:22222/terms",
       |      "privacyPolicyUrl": "http://localhost:22222/privacy",
       |      "accessType": "STANDARD"
       |    },
       |    "state": {
       |      "name": "PENDING_GATEKEEPER_APPROVAL",
       |      "requestedByEmailAddress": "$adminEmail",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "checkInformation": {
       |      "contactDetails": {
       |        "fullname": "Holly Golightly",
       |        "email": "holly.golightly@example.com",
       |        "telephoneNumber": "020 1122 3344"
       |      },
       |      "confirmedName": true,
       |      "providedPrivacyPolicyURL": true,
       |      "providedTermsAndConditionsURL": true,
       |      "applicationDetails": "An application that is pending approval",
       |      "termsOfUseAgreements": [{
       |        "emailAddress": "test@example.com",
       |        "timeStamp": 1459868573962,
       |        "version": "1.0"
       |      }]
       |    },
       |    "approvedDetails": {
       |      "details": {
       |        "id": "",
       |        "clientId": "",
       |        "name": "",
       |        "description": "",
       |        "rateLimitTier": "BRONZE",
       |        "submission": {
       |          "submitterName": "Barry Fakename",
       |          "submitterEmail": "barry.fakename@example.com",
       |          "submittedOn": 1459868573962
       |        },
       |        "reviewContactName": "Harry Golightly",
       |        "reviewContactEmail": "harry.fakename@example.com",
       |        "reviewContactTelephone": "020 1122 3345",
       |        "applicationDetails": ""
       |      },
       |      "admins": [],
       |      "approvedBy": "gatekeeperUserId",
       |      "approvedOn": 1459968573962,
       |      "verified": true
       |    }
       |  },
       |  "history": [
       |      {
       |      "applicationId": "a6d37b4a-0a80-4b7f-b150-5f8f99fe27ea",
       |      "state": "PENDING_GATEKEEPER_APPROVAL",
       |      "actor": {
       |        "id": "$adminEmail",
       |        "actorType": "COLLABORATOR"
       |      },
       |      "changedAt": 1458659208000
       |    },
       |    {
       |      "applicationId": "a6d37b4a-0a80-4b7f-b150-5f8f99fe27ea",
       |      "state": "PENDING_REQUESTER_VERIFICATION",
       |      "actor": {
       |        "id": "gatekeeper.username",
       |        "actorType": "GATEKEEPER"
       |      },
       |      "changedAt": 1459868522961
       |    }
       |  ]
       |}
    """.stripMargin

  val applicationToDelete =
    s"""
       |{
       |  "application": {
       |    "id": "$appToDelete",
       |    "clientId": "clientid1",
       |    "name": "Automated Test Application",
       |    "description": "$applicationDescription",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "$adminEmail",
       |        "role": "ADMINISTRATOR"
       |      },
       |      {
       |        "emailAddress": "$developer",
       |        "role": "DEVELOPER"
       |      },
       |      {
       |        "emailAddress": "$developer8",
       |        "role": "DEVELOPER"
       |      }
       |    ],
       |    "createdOn": 1459866628433,
       |    "redirectUris": [],
       |    "termsAndConditionsUrl": "http://www.example.com/termsAndConditions",
       |    "privacyPolicyUrl": "http://www.example.com/privacy",
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "termsAndConditionsUrl": "http://localhost:22222/terms",
       |      "privacyPolicyUrl": "http://localhost:22222/privacy",
       |      "accessType": "STANDARD"
       |    },
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$adminEmail",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "checkInformation": {
       |      "contactDetails": {
       |        "fullname": "Holly Golightly",
       |        "email": "holly.golightly@example.com",
       |        "telephoneNumber": "020 1122 3344"
       |      },
       |      "confirmedName": true,
       |      "providedPrivacyPolicyURL": true,
       |      "providedTermsAndConditionsURL": true,
       |      "applicationDetails": "An application that is pending approval",
       |      "termsOfUseAgreements": [{
       |        "emailAddress": "test@example.com",
       |        "timeStamp": 1459868573962,
       |        "version": "1.0"
       |      }]
       |
       |    },
       |    "subscriptions": []
       |  },
       |  "history": [
       |      {
       |      "applicationId": "a6d37b4a-0a80-4b7f-b150-5f8f99fe27ea",
       |      "state": "PENDING_GATEKEEPER_APPROVAL",
       |      "actor": {
       |        "id": "$adminEmail",
       |        "actorType": "COLLABORATOR"
       |      },
       |      "changedAt": 1458659208000
       |    },
       |    {
       |      "applicationId": "a6d37b4a-0a80-4b7f-b150-5f8f99fe27ea",
       |      "state": "PENDING_REQUESTER_VERIFICATION",
       |      "actor": {
       |        "id": "gatekeeper.username",
       |        "actorType": "GATEKEEPER"
       |      },
       |      "changedAt": 1459868522961
       |    }
       |  ]
       |}
    """.stripMargin

  val applicationResponse =
    s"""
       |  [{
       |    "id": "$approvedApp1",
       |    "clientId": "clientid1",
       |    "name": "Purnimas Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [
       |    {
       |      "emailAddress": "$developer",
       |     "role": "ADMINISTRATOR"
       |    },
       |    {
       |      "emailAddress": "fred@example.com",
       |     "role": "DEVELOPER"
       |    }
       |    ],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "subscriptions": []
       |  },
       |    {
       |    "id": "df0c32b6-bbb7-46eb-ba50-e6e5459162ff",
       |    "clientId": "clientId1",
       |    "name": "Imrans Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [
       |    {
       |      "emailAddress": "$developer2",
       |     "role": "ADMINISTRATOR"
       |    },
       |    {
       |      "emailAddress": "$developer7",
       |     "role": "DEVELOPER"
       |    },
       |    {
       |      "emailAddress": "$developer8",
       |     "role": "DEVELOPER"
       |    }
       |    ],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer2",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "subscriptions": []
       |  }]
    """.stripMargin

  val applicationResponseForEmail =
    s"""
       |  [{
       |    "id": "$appToDelete",
       |    "clientId": "clientid1",
       |    "name": "Automated Test Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [
       |    {
       |      "emailAddress": "$developer8",
       |     "role": "ADMINISTRATOR"
       |    },
       |    {
       |      "emailAddress": "fred@example.com",
       |     "role": "DEVELOPER"
       |    }
       |    ],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    }
       |  }]
    """.stripMargin

  val applications =
    s"""
       |  [{
       |    "id": "$approvedApp1",
       |    "clientId": "clientid1",
       |    "name": "Purnimas Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [
       |    {
       |      "emailAddress": "$developer",
       |     "role": "ADMINISTRATOR"
       |    },
       |    {
       |      "emailAddress": "fred@example.com",
       |     "role": "DEVELOPER"
       |    }
       |    ],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "subscriptions": []
       |  },
       |    {
       |    "id": "a97541e8-f93d-4d0a-ab0b-862e63204b7d",
       |    "clientId": "clientid1",
       |    "name": "My new app",
       |    "description": "my description",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "$developer5",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1460111080651,
       |    "redirectUris": [
       |      "http://localhost:8080/callback"
       |    ],
       |    "termsAndConditionsUrl": "http://terms",
       |    "privacyPolicyUrl": "http://privacypolicy",
       |    "access": {
       |      "redirectUris": [
       |        "http://localhost:8080/callback"
       |      ],
       |      "termsAndConditionsUrl": "http://terms",
       |      "privacyPolicyUrl": "http://privacypolicy",
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "thomas.fakename@example.com",
       |      "verificationCode": "8mmsC_z9G-rRjt2cjnYP7q9r7aVbmS5cfGv_M-09kdw",
       |      "updatedOn": 1460113878463
       |    },
       |    "trusted": false
       |  },
       |  {
       |    "id": "79ad57d6-3691-45d5-b85d-6b8e0be8bcb1",
       |    "clientId": "clientid1",
       |    "name": "An application for my user",
       |    "description": "And my user has a very tricky email address",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "$developer6",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1465388917873,
       |    "redirectUris": [],
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "TESTING",
       |      "updatedOn": 1476374382580
       |    },
       |    "trusted": false
       |  },
       |  {
       |    "id": "c9736f52-4202-4d14-85b5-cbd29601fa99",
       |    "clientId": "clientid1",
       |    "name": "Mango",
       |    "description": "a",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "$developer9",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1469113456930,
       |    "redirectUris": [],
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PENDING_GATEKEEPER_APPROVAL",
       |      "updatedOn": 1469113456930
       |    },
       |    "trusted": false
       |  },
       |  {
       |    "id": "ac1db09b-f8cf-440a-a3d2-86a81bc6b303",
       |    "clientId": "clientid1",
       |    "name": "Mark App",
       |    "description": "anything",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "gurpreet.fakename@example.com",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1464686294991,
       |    "redirectUris": [],
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "TESTING",
       |      "updatedOn": 1464686294991
       |    },
       |    "trusted": false
       |  },
       |   {
       |    "id": "4afc248d-1c3e-4274-a77b-e89a25b4d764",
       |    "clientId": "clientid1",
       |    "name": "A Wonderful Application",
       |    "description": "I would like to see this wonderful application in production",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "third-party-developer.fakename@example.com",
       |        "role": "ADMINISTRATOR"
       |      },
       |      {
       |        "emailAddress": "bill.fakename@example.com",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1460114002204,
       |    "redirectUris": [],
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PENDING_GATEKEEPER_APPROVAL",
       |      "updatedOn": 1460114644291
       |    },
       |    "trusted": false
       |  },
       |  {
       |    "id": "e55def1d-763c-4a26-a44e-82a63f4cb70b",
       |    "clientId": "clientid1",
       |    "name": "Any App",
       |    "description": "Stuff",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "james.fakename@example.com",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1460623310886,
       |    "redirectUris": [
       |      "http://localhost:9000",
       |      "https://localhost:9000"
       |    ],
       |    "access": {
       |      "redirectUris": [
       |        "http://localhost:9000",
       |        "https://localhost:9000"
       |      ],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "james.fakename@example.com",
       |      "verificationCode": "OHn8PF9xcLllK5G3DN3vYIAyeZAceHyjvd2aG_Is8fQ",
       |      "updatedOn": 1475154623761
       |    },
       |    "trusted": false
       |  },
       |    {
       |    "id": "df0c32b6-bbb7-46eb-ba50-e6e5459162ff",
       |    "clientId": "clientid1",
       |    "name": "Imrans Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [
       |    {
       |      "emailAddress": "$developer2",
       |     "role": "ADMINISTRATOR"
       |    },
       |    {
       |      "emailAddress": "$developer7",
       |     "role": "DEVELOPER"
       |    },
       |    {
       |      "emailAddress": "$developer8",
       |     "role": "DEVELOPER"
       |    }
       |    ],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer2",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "subscriptions": []
       |  }]
    """.stripMargin

  val applicationWithNoSubscription =
    s"""
       |  [{
       |    "id": "$approvedApp1",
       |    "clientId": "clientid1",
       |    "name": "Purnimas Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [
       |    {
       |      "emailAddress": "$developer",
       |     "role": "ADMINISTRATOR"
       |    },
       |    {
       |      "emailAddress": "fred@example.com",
       |     "role": "DEVELOPER"
       |    }
       |    ],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "subscriptions": []
       |  },
       |  {
       |    "id": "414660d0-9b0c-49dc-ad7f-c36f32772c10",
       |    "clientId": "clientid1",
       |    "name": "Tim",
       |    "description": "Tim paye tests",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "admin@example.com",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1460553066047,
       |    "redirectUris": [
       |      "http://localhost:9000"
       |    ],
       |    "access": {
       |      "redirectUris": [
       |        "http://localhost:9000"
       |      ],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "TESTING",
       |      "updatedOn": 1460553066047
       |    },
       |    "trusted": false
       |  },
       |  {
       |    "id": "7800ee15-ccc1-4103-b21f-81ddde793be1",
       |    "clientId": "clientid1",
       |    "name": "Test Application",
       |    "description": "My test app",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "edgar.fakename@example.com",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1469698551644,
       |    "redirectUris": [],
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PENDING_GATEKEEPER_APPROVAL",
       |      "updatedOn": 1469698551644
       |    },
       |    "trusted": false
       |  },
       |  {
       |    "id": "d22cc11f-59e6-4148-b0d4-1751e9181d45",
       |    "clientId": "clientid1",
       |    "name": "QA User App 2",
       |    "collaborators": [
       |      {
       |        "emailAddress": "mtd-qa-test-user@example.com",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1469694187353,
       |    "redirectUris": [
       |      "http://localhost:9000"
       |    ],
       |    "termsAndConditionsUrl": "http://localhost:9000/terms",
       |    "privacyPolicyUrl": "http://localhost:9000/privacy",
       |    "access": {
       |      "redirectUris": [
       |        "http://localhost:9000"
       |      ],
       |      "termsAndConditionsUrl": "http://localhost:9000/terms",
       |      "privacyPolicyUrl": "http://localhost:9000/privacy",
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PENDING_GATEKEEPER_APPROVAL",
       |      "updatedOn": 1469694187353
       |    },
       |    "trusted": false
       |  },
       |  {
       |    "id": "df0c32b6-bbb7-46eb-ba50-e6e5459162ff",
       |    "clientId": "clientid1",
       |    "name": "Imrans Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [
       |    {
       |      "emailAddress": "$developer2",
       |     "role": "ADMINISTRATOR"
       |    },
       |    {
       |      "emailAddress": "$developer7",
       |     "role": "DEVELOPER"
       |    },
       |    {
       |      "emailAddress": "$developer8",
       |     "role": "DEVELOPER"
       |    }
       |    ],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer2",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |   },
       |    "subscriptions": []
       |  }]
    """.stripMargin


  val applicationResponseWithNoUsers =
    s"""
       |  [{
       |    "id": "$approvedApp1",
       |    "clientId": "clientid1",
       |    "name": "Purnimas Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "subscriptions": []
       |  }]
    """.stripMargin

  val applicationResponsewithNoSubscription =
    s"""
       |  [{
       |    "id": "$approvedApp1",
       |    "clientId": "clientid1",
       |    "name": "Purnimas Application",
       |    "description": "application for test",
       |    "deployedTo": "PRODUCTION",
       |   "collaborators": [
       |    {
       |      "emailAddress": "$developer4",
       |     "role": "ADMINISTRATOR"
       |    },
       |    {
       |      "emailAddress": "$developer5",
       |     "role": "DEVELOPER"
       |    },
       |    {
       |      "emailAddress": "$developer6",
       |     "role": "DEVELOPER"
       |    },
       |    {
       |      "emailAddress": "peter.fakename@example.com",
       |     "role": "DEVELOPER"
       |    }
       |    ],
       |    "createdOn": 1458832690624,
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    "state": {
       |      "name": "PRODUCTION",
       |      "requestedByEmailAddress": "$developer4",
       |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
       |      "updatedOn": 1459868573962
       |    },
       |    "subscriptions": []
       |  }]
    """.stripMargin

  val allUsers =
    s"""
       |[
       |  {
       |    "email": "$developer",
       |    "firstName": "$devFirstName",
       |    "lastName": "$devLastName",
       |    "verified": true
       |  },
       |  {
       |    "email": "$developer2",
       |    "firstName": "$dev2FirstName",
       |    "lastName": "$dev2LastName",
       |    "verified": true
       |  },
       |  {
       |    "email": "$developer4",
       |    "firstName": "$dev4FirstName",
       |    "lastName": "$dev4LastName",
       |    "verified": true
       |  },
       |  {
       |    "email": "$developer5",
       |    "firstName": "$dev5FirstName",
       |    "lastName": "$dev5LastName",
       |    "verified": false
       |  },
       |  {
       |    "email": "$developer6",
       |    "firstName": "$dev6FirstName",
       |    "lastName": "$dev6LastName",
       |    "verified": true
       |  },
       |  {
       |    "email": "$developer7",
       |    "firstName": "$dev7FirstName",
       |    "lastName": "$dev7LastName",
       |    "verified": true
       |  },
       |  {
       |    "email": "$developer8",
       |    "firstName": "$dev8FirstName",
       |    "lastName": "$dev8LastName",
       |    "verified": false
       |  }
       |]
   """.stripMargin

  val user =
    s"""
       |  {
       |    "email": "$developer8",
       |    "firstName": "$dev8FirstName",
       |    "lastName": "$dev8LastName",
       |    "verified": false
       |  }
   """.stripMargin


  def approvedApplication(description: String = "", verified: Boolean = false) = {
    val verifiedHistory = if (verified) {
      s""",
          |    {
          |      "applicationId": "$approvedApp1",
          |      "clientId": "clientid1",
          |      "state": "PRODUCTION",
          |      "actor": {
          |        "id": "gatekeeper.username",
          |        "actorType": "GATEKEEPER"
          |      },
          |      "changedAt": 1459868522961
          |    }
      """.stripMargin
    } else {
      ""
    }

    val state = if (verified) {
      s"""
         |    "state": {
         |      "name": "PRODUCTION",
         |      "requestedByEmailAddress": "$adminEmail",
         |      "updatedOn": 1459868573962
         |    }
      """.stripMargin
    } else {
      s"""
         |    "state": {
         |      "name": "PENDING_REQUESTER_VERIFICATION",
         |      "requestedByEmailAddress": "$adminEmail",
         |      "verificationCode": "pRoPW05BMTQ_HqzTTR0Ent10py9gvstX34_a3dxx4V8",
         |      "updatedOn": 1459868573962
         |    }
      """.stripMargin
    }

    s"""
       |{
       |  "application": {
       |    "id": "$approvedApp1",
       |    "clientId": "clientid1",
       |    "name": "Application",
       |    "description": "$description",
       |    "deployedTo": "PRODUCTION",
       |    "collaborators": [
       |      {
       |        "emailAddress": "$adminEmail",
       |        "role": "ADMINISTRATOR"
       |      },
       |      {
       |        "emailAddress": "collaborator@example.com",
       |        "role": "DEVELOPER"
       |      },
       |      {
       |        "emailAddress": "$admin2Email",
       |        "role": "ADMINISTRATOR"
       |      }
       |    ],
       |    "createdOn": 1459866628433,
       |    "redirectUris": [],
       |    "subscriptions": [],
       |    "access": {
       |      "redirectUris": [],
       |      "overrides": [],
       |      "accessType": "STANDARD"
       |    },
       |    "rateLimitTier": "BRONZE",
       |    $state
       |  },
       |  "history": [
       |      {
       |      "applicationId": "$approvedApp1",
       |      "state": "PENDING_GATEKEEPER_APPROVAL",
       |      "actor": {
       |        "id": "$adminEmail",
       |        "actorType": "COLLABORATOR"
       |      },
       |      "changedAt": 1458659208000
       |    },
       |    {
       |      "applicationId": "$approvedApp1",
       |      "state": "PENDING_REQUESTER_VERIFICATION",
       |      "actor": {
       |        "id": "gatekeeper.username",
       |        "actorType": "GATEKEEPER"
       |      },
       |      "changedAt": 1459868522961
       |    }
       |    $verifiedHistory
       |  ]
       |}
    """.stripMargin
  }

  val apiDefinition =
    s"""
    |[
    | {
    |   "serviceName": "employersPayeAPI",
    |   "serviceBaseUrl": "http://employerspaye-api.protected.mdtp/",
    |   "name": "Employers PAYE",
    |   "description": "EMPLOYERS PAYE API.",
    |    "deployedTo": "PRODUCTION",
    |   "context": "employers-paye",
    |   "versions": [
    |     {
    |       "version": "1.0",
    |       "status": "PUBLISHED",
    |       "access": {
    |         "type": "PUBLIC"
    |       },
    |       "endpoints": [
    |         {
    |           "uriPattern": "/qwerty",
    |           "endpointName": "employersPayeAPI",
    |           "method": "GET",
    |           "authType": "USER",
    |           "throttlingTier": "UNLIMITED",
    |           "scope": "read:employers-paye-1"
    |         }
    |       ]
    |     }
    |   ],
    |   "requiresTrust": false
    | },
    |  {
    |   "serviceName": "payeCreditsAPI",
    |   "serviceBaseUrl": "http://payecredits-api.protected.mdtp/",
    |   "name": "Paye Credits",
    |   "description": "PAYE CREDITS API",
    |    "deployedTo": "PRODUCTION",
    |   "context": "paye-credits",
    |   "versions": [
    |     {
    |       "version": "1.0",
    |       "status": "DEPRECATED",
    |       "access": {
    |         "type": "PUBLIC"
    |       },
    |       "endpoints": [
    |         {
    |           "uriPattern": "/qwerty",
    |           "endpointName": "payeCreditsAPI",
    |           "method": "GET",
    |           "authType": "USER",
    |           "throttlingTier": "UNLIMITED",
    |           "scope": "read:paye-credits-1"
    |         }
    |       ]
    |     }
    |   ],
    |   "requiresTrust": false
    | },
    |  {
    |   "serviceName": "individualBenefitsAPI",
    |   "serviceBaseUrl": "http://individualbenefits-api.protected.mdtp/",
    |   "name": "Individual Benefits",
    |   "description": "INDIVIDUAL BENEFITS API.",
    |    "deployedTo": "PRODUCTION",
    |   "context": "individual-benefits",
    |   "versions": [
    |     {
    |       "version": "1.0",
    |       "status": "PUBLISHED",
    |       "access": {
    |         "type": "PUBLIC"
    |       },
    |       "endpoints": [
    |         {
    |           "uriPattern": "/qwerty",
    |           "endpointName": "individualBenefitsAPI",
    |           "method": "GET",
    |           "authType": "USER",
    |           "throttlingTier": "UNLIMITED",
    |           "scope": "read:individual-benefits-1"
    |         }
    |       ]
    |     }
    |   ],
    |   "requiresTrust": false
    | },
    |   {
    |   "serviceName": "selfAssessmentAPI",
    |   "serviceBaseUrl": "http://selfassessment-api.protected.mdtp/",
    |   "name": "Self Assessment",
    |   "description": "SELF ASSESSMENT API.",
    |    "deployedTo": "PRODUCTION",
    |   "context": "self-assessment",
    |   "versions": [
    |     {
    |       "version": "1.0",
    |       "status": "PUBLISHED",
    |       "access": {
    |         "type": "PUBLIC"
    |       },
    |       "endpoints": [
    |         {
    |           "uriPattern": "/qwerty",
    |           "endpointName": "selfAssessmentAPI",
    |           "method": "GET",
    |           "authType": "USER",
    |           "throttlingTier": "UNLIMITED",
    |           "scope": "read:self-assessment-1"
    |         }
    |       ]
    |     }
    |   ],
    |   "requiresTrust": false    
    | }
    |]
  """.stripMargin

  val StringGenerator = (n: Int) => Gen.listOfN(n, Gen.alphaChar).map(_.mkString)

  private val DeveloperGenerator: Gen[User] = for {
    forename <- StringGenerator(5)
    surname <- StringGenerator(5)
    email =  randomEmail
    verified = Option(true)
    registered = None
  } yield User(email, forename, surname, verified)

  def userListGenerator(number:Int): Gen[List[User]] = Gen.listOfN(number, DeveloperGenerator)

  def developerListJsonGenerator(number:Int): Option[String] = userListGenerator(number)
    .sample.map(_.sortWith((userA, userB) => userA.lastName > userB.lastName))
    .map(userList => Json.toJson(userList))
    .map(Json.stringify)


  def administrator(email: String = adminEmail, firstName: String = firstName, lastName: String = lastName) =
    s"""
       |{
       |"email": "$email",
       |"firstName": "$firstName",
       |"lastName": "$lastName",
       |"registrationTime": 1458300873012,
       |"lastModified": 1458300877382,
       |"verified": true
       |}
     """.stripMargin


  val applicationSubscription =
    s"""
       [
       |  {
       |    "apiIdentifier": {
       |      "context": "individual-benefits",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "a97541e8-f93d-4d0a-ab0b-862e63204b7d",
       |      "4bf49df9-523a-4aa3-a446-683ff24b619f",
       |      "42695949-c7e8-4de9-a443-15c0da43143a"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "individual-employment",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "4bf49df9-523a-4aa3-a446-683ff24b619f",
       |      "42695949-c7e8-4de9-a443-15c0da43143a",
       |      "95b381b8-499d-41e9-99b4-dbfed6a05752"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "individual-tax",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "42695949-c7e8-4de9-a443-15c0da43143a"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "individual-income",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "42695949-c7e8-4de9-a443-15c0da43143a",
       |      "1abf06bf-45d7-47a9-aa1c-61fe4729f5b8"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "inheritance-tax",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "42695949-c7e8-4de9-a443-15c0da43143a",
       |      "1abf06bf-45d7-47a9-aa1c-61fe4729f5b8",
       |      "79ad57d6-3691-45d5-b85d-6b8e0be8bcb1",
       |      "58dd6642-08c9-4422-8a84-058e8731d44a"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "national-insurance",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "42695949-c7e8-4de9-a443-15c0da43143a",
       |      "1abf06bf-45d7-47a9-aa1c-61fe4729f5b8"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "national-insurance-record",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "42695949-c7e8-4de9-a443-15c0da43143a",
       |      "1abf06bf-45d7-47a9-aa1c-61fe4729f5b8"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "marriage-allowance",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "42695949-c7e8-4de9-a443-15c0da43143a",
       |      "1abf06bf-45d7-47a9-aa1c-61fe4729f5b8",
       |      "ac1db09b-f8cf-440a-a3d2-86a81bc6b303"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "api-simulator",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "b69cfde4-3e62-48a3-93fd-cf5a1f5fd1be",
       |      "4fecb42e-15cb-4e91-8292-55ae406878e9",
       |      "58dd6642-08c9-4422-8a84-058e8731d44a",
       |      "af57d193-c9dd-4fdb-a790-656429c2f1dc",
       |      "ab349380-17cc-4de0-a7ac-c76baedd7133"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "employers-paye",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "e55def1d-763c-4a26-a44e-82a63f4cb70b",
       |      "10ff725b-9555-4919-a596-0850a3e83caa",
       |      "ac1db09b-f8cf-440a-a3d2-86a81bc6b303",
       |      "4afc248d-1c3e-4274-a77b-e89a25b4d764"
       |    ]
       |  },
       |  {
       |    "apiIdentifier": {
       |      "context": "self-assessment-api",
       |      "version": "1.0"
       |    },
       |    "applications": [
       |      "c9736f52-4202-4d14-85b5-cbd29601fa99",
       |      "10ff725b-9555-4919-a596-0850a3e83caa",
       |      "42695949-c7e8-4de9-a443-15c0da43143a"
       |    ]
       |  }
       |]
   """.stripMargin

}
