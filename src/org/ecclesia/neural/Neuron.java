package org.ecclesia.neural;

import java.util.Random;

import org.ecclesia.neural.util.Mathematics;

/**
 * 
 * @author Sammy Shin, Trevor Thai Kim Nguyen, Christian Duffee
 *
 */
public class Neuron {
	final static float mutationChance = 0.10f;
	final static float changeFactor = 1.00f;

	private float[] weights;
	private float input;

	/**
	 * Initially generates a Random Neuron
	 * 
	 * @param width
	 */
	public Neuron(int width) {
		Random random = new Random();
		weights = new float[width];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = random.nextFloat() * (random.nextBoolean() ? 1 : -1);
		}
	}

	/**
	 * Reproduces a Neuron based on Parent with some mutations
	 * 
	 * @param parent
	 */
	public Neuron(Neuron parent) {
		Random random = new Random();
		weights = parent.getWeights().clone();
		for (int i = 0; i < weights.length; i++) {
			if (random.nextFloat() <= mutationChance) {
				weights[i] = weights[i] + (random.nextBoolean() ? 1 : -1) * changeFactor * random.nextFloat();
				weights[i] = Math.max(weights[i], -1);
				weights[i] = Math.min(weights[i], 1);
			}
		}
	}

	/**
	 * Resets Input
	 */
	private void resetInput() {
		input = 0;
	}

	/**
	 * Adds value to inputs
	 * 
	 * @param value
	 */
	public void addInput(float value) {
		input += value;
	}

	/**
	 * Gets the Neuron's output based on a sigmoid function and then resets the
	 * input
	 */
	public float[] getOutput() {
		float[] output = new float[weights.length];
		for (int i = 0; i < weights.length; i++) {
			output[i] = Mathematics.getSigmoidValue(input * weights[i]);
		}
		resetInput();
		return output;
	}

	public float[] getWeights() {
		return weights;
	}
	
}
