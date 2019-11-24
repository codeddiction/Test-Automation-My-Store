package com.auto.runners;

import org.junit.runner.RunWith;

import com.auto.general.Constants;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {Constants.featureFileLocation},
glue = {"com.auto.steps"}
)

public class Runner {
	
}
