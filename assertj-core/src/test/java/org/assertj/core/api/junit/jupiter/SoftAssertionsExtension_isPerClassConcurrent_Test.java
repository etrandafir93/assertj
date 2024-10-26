package org.assertj.core.api.junit.jupiter;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@ExtendWith(SoftAssertionsExtension.class)
class SoftAssertionsExtension_isPerClassConcurrent_Test {

  @InjectSoftAssertions
  private SoftAssertions softly;

  @Test
  void t1() {
    softly.assertThat(1).isEqualTo(2);
  }

  @Nested
  @Execution(ExecutionMode.CONCURRENT)
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  class InnerTestClass {

    @Test
    void t2() {
      softly.assertThat(1).isEqualTo(2);
    }
  }

}