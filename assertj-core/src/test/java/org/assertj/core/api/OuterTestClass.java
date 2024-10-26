package org.assertj.core.api;

import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@ExtendWith({ SoftAssertionsExtension.class })
public class OuterTestClass {

  @InjectSoftAssertions
  private SoftAssertions softly;

  @Nested
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  @Execution(ExecutionMode.CONCURRENT)
  class InnerTestClass {
    @Test
    void ffff() {
      softly.assertThat(1).isEqualTo(2);
    }

    @Test
    void gggg() {
      softly.assertThat(1).isEqualTo(2);
    }
  }

  @Test
  void ffqq() {
    softly.assertThat(1).isEqualTo(2);
  }

}
