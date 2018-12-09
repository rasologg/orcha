package io.rasolog.provisioning.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProvisioninRuntimeBundleController {


    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/provision")
    public String startProvisioning(@RequestBody Map<String, Object> vars){
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("mobile-provisioning", vars);
        return processInstance.getProcessInstanceId();
    }

}

