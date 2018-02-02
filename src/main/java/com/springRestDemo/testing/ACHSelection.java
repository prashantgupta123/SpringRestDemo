package com.springRestDemo.testing;

import java.awt.datatransfer.*;
import java.io.IOException;
import java.io.Reader;
import java.util.Vector;

public class ACHSelection implements Transferable, ClipboardOwner {

    public ACHSelection() {
        super();
    }

    /**
     * A <code>Transferable</code> which implements the capability required to
     * transfer an <code>ACHRecord</code>.
     *
     * @see DataFlavor#stringFlavor
     */

    public static final DataFlavor achRecordFlavor = new DataFlavor(
            ACHRecord.class, "ACHRecord");

    private static final DataFlavor[] flavors = {achRecordFlavor,
            DataFlavor.stringFlavor};

    private Vector<ACHRecord> data;

    /**
     * Creates a <code>Transferable</code> capable of transferring the
     * specified <code>String</code>.
     */
    public ACHSelection(Vector<ACHRecord> data) {
        this.data = data;
    }

    /**
     * Returns an array of flavors in which this <code>Transferable</code> can
     * provide the data. <code>DataFlavor.stringFlavor</code> is properly
     * supported. Support for <code>DataFlavor.plainTextFlavor</code> is
     * <b>deprecated</b>.
     *
     * @return an array of length two, whose elements are <code>DataFlavor.
     * stringFlavor</code>
     * and <code>DataFlavor.plainTextFlavor</code>
     */
    public DataFlavor[] getTransferDataFlavors() {
        // returning flavors itself would allow client code to modify
        // our internal behavior
        return (DataFlavor[]) flavors.clone();
    }

    /**
     * Returns whether the requested flavor is supported by this
     * <code>Transferable</code>.
     *
     * @param flavor the requested flavor for the data
     * @return true if <code>flavor</code> is equal to
     * <code>DataFlavor.stringFlavor</code>; false if
     * <code>flavor</code> is not one of the above flavors
     * @throws NullPointerException if flavor is <code>null</code>
     */
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        for (int i = 0; i < flavors.length; i++) {
            if (flavor.equals(flavors[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the <code>Transferable</code>'s data in the requested
     * <code>DataFlavor</code> if possible. If the desired flavor is
     * <code>DataFlavor.stringFlavor</code>, or an equivalent flavor, the
     * <code>String</code> representing the selection is returned. If the
     * desired flavor is <code>DataFlavor.plainTextFlavor</code>, or an
     * equivalent flavor, a <code>Reader</code> is returned. <b>Note:</b> The
     * behavior of this method for <code>DataFlavor.plainTextFlavor</code> and
     * equivalent <code>DataFlavor</code>s is inconsistent with the
     * definition of <code>DataFlavor.plainTextFlavor</code>.
     *
     * @param flavor the requested flavor for the data
     * @return the data in the requested flavor, as outlined above
     * @throws UnsupportedFlavorException if the requested data flavor is not equivalent to either
     *                                    <code>DataFlavor.stringFlavor</code>
     * @throws IOException                if an IOException occurs while retrieving the data. By
     *                                    default, StringSelection never throws this exception, but a
     *                                    subclass may.
     * @throws NullPointerException       if flavor is <code>null</code>
     * @see Reader
     */
    public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException, IOException {
        if (flavor.equals(achRecordFlavor)) {
            return data;
        } else if (flavor.equals(DataFlavor.stringFlavor)) {
            StringBuffer output = new StringBuffer("");
            for (int i = 0; i < data.size(); i++) {
                if (i > 0) {
                    output.append("\n");
                }
                output.append(data.get(i).toString());
            }
            return output.toString();
        } else {

            throw new UnsupportedFlavorException(flavor);
        }
    }

    public void lostOwnership(Clipboard clipboard, Transferable contents) {
    }

}
