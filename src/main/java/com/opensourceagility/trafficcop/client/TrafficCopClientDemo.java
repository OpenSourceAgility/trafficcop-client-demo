/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensourceagility.trafficcop.client;


import org.springframework.social.trafficcop.api.TrafficCop;
import org.springframework.social.trafficcop.api.impl.TrafficCopTemplate;
import org.springframework.util.Assert;

/**
 * Test Harness that uses an access token to connect to Trafficcop and request a proxied service
 * 
 * @author Michael Lavelle
 *
 */
public class TrafficCopClientDemo {
	
	public static void main(String[] args)
	{
		// Check that we are passed two arguments - the api base url and an access token
		Assert.isTrue(args.length == 2,"Usage: TrafficCopClientDemo <trafficCopBaseUrl> <accessToken>");
		
		// Construct new REST OAuth client for TrafficCop, configured with the access token 
		TrafficCop trafficCop = new TrafficCopTemplate(args[0],args[1]);
		
		// Access a proxied service
		String message = trafficCop.proxiedServiceOperations().getMessage();
		
		// Print out the message from the service
		System.out.println("Message returned from TrafficCop's proxied service is: " + message);
	}

}
