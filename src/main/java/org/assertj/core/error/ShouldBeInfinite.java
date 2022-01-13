/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2022 the original author or authors.
 */
package org.assertj.core.error;

public class ShouldBeInfinite extends BasicErrorMessageFactory {

  public static ErrorMessageFactory shouldBeInfinite(Number actual) {
    return new ShouldBeInfinite(actual);
  }

  private ShouldBeInfinite(Number actual) {
    super("%nExpecting %s to be infinite", actual);
  }
}
