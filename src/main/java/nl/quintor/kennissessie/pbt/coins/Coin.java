package nl.quintor.kennissessie.pbt.coins;

public enum Coin {
    $2_00(200),
    $1_00(100),
    $0_50( 50),
    $0_20( 20),
    $0_10( 10),
    $0_05(  5),
    $0_01(  1);

    /**
     * The value of the coin, in cents.
     */
    public final int value;

    Coin(int value) {
        this.value = value;
    }
}
