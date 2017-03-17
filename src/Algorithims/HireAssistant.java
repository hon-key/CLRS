package Algorithims;
import java.util.Random;

/**
 * Created by caihongji on 2017/3/17.
 * 算法:雇佣算法
 */
public class HireAssistant {
    private int best;
    private int count;
    public HireAssistant() {}

    public void hireDirectly(int... seq) {
        best = 0;count = 0;
        hireLogic(seq);
    }
    public void hireRandomly(int... seq) {
        best = 0;count = 0;
        randomlyPermute(seq);
        hireLogic(seq);
    }
    private void hireLogic(int[] seq) {
        for (int i = 0;i < seq.length; i++) {
            boolean isBetterThanBest = interview(seq[i]);
            if (isBetterThanBest) {
                best = seq[i];
                hire(seq[i]);
            }
        }
        System.out.println("Sum of the hire:" + count);
        System.out.println("Final hire: " + best);
    }

    private boolean interview(int i) {
        if (i > best) return true;
        return false;
    }
    private void hire(int i) {
        count++;
        System.out.println("Hire: " + i);
    }
    public void randomlyPermute(int[] seq) {
        Random random = new Random();
        for (int i = 0; i < seq.length; i++) {
            int index = random.nextInt(seq.length - i);
            index = i + index;
            int tmp = seq[i];
            seq[i] = seq[index];
            seq[index] = tmp;
        }
    }
}
