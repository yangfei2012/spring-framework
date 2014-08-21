package org.fei.tester;

/**
 * Created by fei on 14-8-20.
 */
public class TProvider {
    private TListener tListener;

    public TProvider(TListener tListener) {
        this.tListener = tListener;
    }

    public void haha() {
        tListener.haha();
    }
}
