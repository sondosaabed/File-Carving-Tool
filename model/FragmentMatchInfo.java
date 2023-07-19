/**
 * 
 */
package model;

/**
 * This class I created to show the frgment file information of the table view
 */
public class FragmentMatchInfo {
	// Feilds
	private int fragmentNumber;
    private String originalFileHash;
    private String searchResultFileHash;
    private boolean match;
    /*
     * Constructor
     */
    /**
     * @param fragmentNumber
     * @param originalFileHash
     * @param searchResultFileHash
     * @param match
     */
    public FragmentMatchInfo(int fragmentNumber, String originalFileHash, String searchResultFileHash, boolean match) {
        this.setFragmentNumber(fragmentNumber);
        this.setOriginalFileHash(originalFileHash);
        this.setSearchResultFileHash(searchResultFileHash);
        this.setMatch(match);
    }

	/**
	 * @return the fragmentNumber
	 */
	public int getFragmentNumber() {
		return fragmentNumber;
	}

	/**
	 * @param fragmentNumber the fragmentNumber to set
	 */
	public void setFragmentNumber(int fragmentNumber) {
		this.fragmentNumber = fragmentNumber;
	}

	/**
	 * @return the match
	 */
	public boolean isMatch() {
		return match;
	}

	/**
	 * @param match the match to set
	 */
	public void setMatch(boolean match) {
		this.match = match;
	}

	/**
	 * @return the searchResultFileHash
	 */
	public String getSearchResultFileHash() {
		return searchResultFileHash;
	}

	/**
	 * @param searchResultFileHash the searchResultFileHash to set
	 */
	public void setSearchResultFileHash(String searchResultFileHash) {
		this.searchResultFileHash = searchResultFileHash;
	}

	/**
	 * @return the originalFileHash
	 */
	public String getOriginalFileHash() {
		return originalFileHash;
	}

	/**
	 * @param originalFileHash the originalFileHash to set
	 */
	public void setOriginalFileHash(String originalFileHash) {
		this.originalFileHash = originalFileHash;
	}
}