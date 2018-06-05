package edu.hm.bartolov.a08_mvc.view;

/* (C) 2018, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_121, Linux i386 4.15.4
 * bluna: Intel Core i7-5600U/2600 MHz, 4 Core(s), 15936 MByte RAM
 **/
/** Nachrichtentexte fuer einen Viewer, der auf System.out protokolliert.
 * @author R. Schiedermeier, rs@cs.hm.edu
 * @version 2018-05-21
 */
enum Callout {
    /** Die Ordnungsnummer der Nachrichten entspricht der Anzahl verbleibender Schritte. */
    Done("%d zum Dritten, verkauft!", "Keine Gebote, nicht verkauft."),
    Going2nd("%d zum Zweiten ...", "%d zum Zweiten ..."),
    Going1st("%d zum Ersten ...", "%d zum Ersten ..."),
    Remaining3("noch %d geboten, hoere ich mehr?", "Mindestgebot noch %d, bietet jemand?"),
    Remaining4("%d geboten, hoere ich mehr?", "Mindestgebot %d, bietet jemand?"),
    NewBid("%d geboten!", "Mindestgebot %d");

    /** Nachrichtentext mit Gebot. */
    private final String formatBid;

    /** Nachrichtentext ohne Gebot. */
    private final String formatNobid;

    Callout(String formatBid, String formatNobid) {
        this.formatBid = formatBid;
        this.formatNobid = formatNobid;
    }

    public String getFormatNobid() {
        return formatNobid;
    }

    public String getFormatBid() {
        return formatBid;
    }
}
