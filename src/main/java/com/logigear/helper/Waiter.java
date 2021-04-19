package com.logigear.helper;

import java.time.Duration;
import java.util.concurrent.Callable;

import static org.awaitility.Awaitility.with;

public class Waiter {

    public static void waitForCondition(Callable<Boolean> conditionEvaluator) {
        with().pollInSameThread().await().until(conditionEvaluator);
    }

    public static void waitForCondition(Callable<Boolean> conditionEvaluator, Duration pollInterval, Duration timeout) {
        with().pollInSameThread().pollInterval(pollInterval).timeout(timeout).until(conditionEvaluator);
    }
}
