package com.camunda.training;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.extension.process_test_coverage.junit5.ProcessEngineCoverageExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.runtimeService;

@ExtendWith(ProcessEngineCoverageExtension.class)
class ProcessJUnitTest {
  
  @Test
  @Deployment(resources = "education_process_app.bpmn")
  void testHappyPath() {
    Map<String, Object> variables = new HashMap<String, Object>();
    variables.put("approved", true);
    variables.put("content", "Exercise 4 test - YOUR NAME HERE");
    ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("TwitterQAProcess", variables);
    assertThat(processInstance).isEnded();
  }

  @Test
  @Deployment(resources = "education_process_app.bpmn")
  void testUnhappyPath() {
    Map<String, Object> variables = new HashMap<String, Object>();
    variables.put("approved", false);
    variables.put("content", "Exercise 4 test - YOUR NAME HERE");
    ProcessInstance processInstance = runtimeService().startProcessInstanceByKey("TwitterQAProcess", variables);
    assertThat(processInstance).isEnded();
  }

}
