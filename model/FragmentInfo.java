/**
 * 
 */
package model;

/**
 * 	In this class I created a Fragment Information that is used to be shown in the table biew
 */
public class FragmentInfo {
    //Feilds
	private int fragmentNumber;
    private long size;
    private String hashValue;
    /*
     * Constructor
     */
    /**
     * @param fragmentNumber
     * @param size
     * @param hashValue
     */
    public FragmentInfo(int fragmentNumber, long size, String hashValue) {
        this.fragmentNumber = fragmentNumber;
        this.size = size;
        this.hashValue = hashValue;
    }

    /**
     * @return fragmentNumber
     */
    public int getFragmentNumber() {
        return fragmentNumber;
    }

    /**
     * @return the size 
     */
    public long getSize() {
        return size;
    }

    /**
     * @return the hash value
     */
    public String getHashValue() {
        return hashValue;
    }
}
