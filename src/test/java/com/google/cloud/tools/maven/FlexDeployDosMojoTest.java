/*
 * Copyright (C) 2017 Google Inc.
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

package com.google.cloud.tools.maven;

import static org.mockito.Mockito.verify;

import com.google.cloud.tools.maven.util.SingleYamlFlexibleDeployTestHelper;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FlexDeployDosMojoTest {

  private DeployDosMojo mojo = new DeployDosMojo();
  
  private TemporaryFolder tempFolder = new TemporaryFolder();
  
  private SingleYamlFlexibleDeployTestHelper<DeployDosMojo> testFixture =
      new SingleYamlFlexibleDeployTestHelper<>(mojo, tempFolder);
  
  @Rule
  public TestRule testRule = RuleChain.outerRule(tempFolder).around(testFixture);
  
  @Test
  public void testDeployFlexible() throws Exception {
    mojo.execute();

    verify(testFixture.getDeploymentMock()).deployDos(mojo);
  }
}