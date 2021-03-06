/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.trustedanalytics.servicebroker.h2o.service;

import org.cloudfoundry.community.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.cloudfoundry.community.servicebroker.model.CreateServiceInstanceRequest;

public class CfBrokerRequestsFactory {
  public static CreateServiceInstanceRequest getCreateInstanceRequest(String serviceInstanceId) {
    return new CreateServiceInstanceRequest("serviceDefinitionId", "planId", "organizationGuid",
        "spaceGuid").withServiceInstanceId(serviceInstanceId);
  }

  public static CreateServiceInstanceBindingRequest getCreateServiceBindingRequest(
      String instanceId, String bindingId) {

    return new CreateServiceInstanceBindingRequest(
        getCreateInstanceRequest(instanceId).getServiceDefinitionId(), "planId", "appGuid")
            .withBindingId(bindingId).withServiceInstanceId(instanceId);
  }
}
