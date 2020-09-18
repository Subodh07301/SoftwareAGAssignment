package com.main.assignment3;

/**
 * 3. Statistic Calculator
 * The task here is to implement this interface. If you want to write multiple implementations then that is good,
 * or you can focus down on writing just one. Some notes regarding implementations:
 * ● Implementations of this class must be 'thread-safe'. The definition of the term 'thread-safe'
 * is left up to you.
 *
 * ● Implementations may choose to prioritize (or not) various aspects of the performance and or behavior of their instances -
 * this is acceptable as long as the compromise can be explained and justified.
 *
 * ● You are free to choose appropriate behavior for any corner cases but are expected to be able to justify those behaviors.
 *
 * ● If you want to optimize for ‘performance’ (whatever you take performance to mean) here at the expense of code readability
 * then that is fine, but you’ll need to be able to explain the code to us. If something appears counter-intuitive or overly complex
 * then code comments can be useful.
 */

public class SolutionForAssignement3 implements Statistic{
    private  int minValue;
    private  int maxValue;

    private  float  meanValue;
    private  float variance;

    private  int value;
    private  int count;

    public SolutionForAssignement3(){
        minValue=Integer.MAX_VALUE;
        maxValue=Integer.MIN_VALUE;
        meanValue=0.0f;
        variance=0.0f;
        count=0;
    }

    @Override
    synchronized public void event(int value) {
        this.value=value;
        count++;
    }

    @Override
    synchronized public float mean() {
        meanValue=(meanValue*(count-1)+value)/(count);
        return meanValue;
    }

    @Override
    synchronized public int minimum() {
        minValue=Math.min(minValue,value);
        return minValue;

    }

    @Override
    synchronized public int maximum() {
        maxValue=Math.max(maxValue,value);
        return maxValue;
    }

    @Override
    synchronized public float variance() {
        return variance=(variance+((value-meanValue)*(value-meanValue)))/(count);
    }
}

/**
 * Tracks the statistics of a continual stream of values. */
interface Statistic {
    /*
     * Called to update the statistic with a new sample value. */
    void event(int value);
    /*
     * Returns the mean of the received sample values. */
    float mean();
    /*
     * Returns the minimal received sample value. */
    int minimum();
    /*
     * Returns the maximal received sample value. */
    int maximum();
    /*
     * Returns an estimate of the variance of the total population * given the received sample values.
     */
    float variance();
}