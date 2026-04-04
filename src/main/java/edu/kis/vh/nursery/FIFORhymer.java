package edu.kis.vh.nursery;

/**
 Dziedziczenie po DeafultCountingOutRhymer
 Zamiana na kolejke
 */
public class FIFORhymer extends DefaultCountingOutRhymer {
    /**
     stos do odwracania kolejnosci elementow
     */
    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     nadpisana metoda countOut
     * @return pierwsza dodana wartosc lub wartosc domyslna
     */
    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }

    /**
     *
     * @return obiekt DefaultCountingOutRhymer
     */
    public DefaultCountingOutRhymer getTemp() {
        return temp;
    }
}
