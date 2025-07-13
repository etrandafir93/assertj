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
 * Copyright 2012-2025 the original author or authors.
 */
package org.assertj.core.api.path;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.PathAssert;
import org.assertj.core.internal.Diff;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PathAssert_hasContent_newLines_Test {

  @TempDir
  Path tempDir;

  @ParameterizedTest
  @ValueSource(strings = {
    // succeeds for
    "CONTENT",
    "CONTENT\n",
    "CONTENT\r",
    "CONTENT\r\n",

    // fails for
    "\nCONTENT",
    "\rCONTENT",
    "\n\rCONTENT"
  })
  void test(String expectedContent) throws IOException {
    Path path = tempDir.resolve("text_with_new_lines.txt");
    Files.write(path, "CONTENT".getBytes(), StandardOpenOption.CREATE);

    PathAssert.assertThatPath(path)
      .hasContent(expectedContent);
  }

  @Test
  void readerFor() {
    assertThat(Diff.readerFor("CONTENT\n").lines())
      .hasSize(1);

    assertThat(Diff.readerFor("\nCONTENT").lines())
      .hasSize(2);
  }

}
