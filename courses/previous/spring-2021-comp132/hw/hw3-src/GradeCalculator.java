
/**
 * Find the letter grade associated with a particular score
 * 
 * @author Tim Wahls
 *
 */
public class GradeCalculator
{
	// the number of points on the assignment
	private int numPoints;

	/**
	 * set the number of points on the assignment
	 * @param initPoints the number of points on the assignment
	 */
	public GradeCalculator(int initPoints)
	{
		numPoints = initPoints;
	}

	/** return the letter grade associated with a particular score 
	 *  @param the score on the assignment
	 *  @return the letter grade associated with a particular score 
	 */
    public String grade(int score) {
        
        int pct = (score * 100) / numPoints; // percentage on the assignment
        String letGrade = "X"; // the letter grade on the assignment
        if (pct >= 90) {
            letGrade = "A";
        } else if (pct >= 80) {
            letGrade = "B";
        } else if (pct >= 70) {
            letGrade = "C";
        } else {
            letGrade = "other";
        }
        return letGrade;
    }
    
    /** determine whether or not the percentage on the assignment is passing.
     * If we are using easy grading (the grading level is 1), any score giving
     * a percentage of 60 or higher is passing.  If we are using hard grading
     * (the grading level is 2), any score giving a percentage of 75 or higher
     * is passing.  You can assume that the grading level is always either 
     * 1 or 2.
     * @param gradingLevel whether to use easy or hard grading
     * @param score the score on the assignment
     * @return whether or not the score gives a passing percentage
     */
    public boolean passingGrade(int gradingLevel, int score) {
        return false;
    }
        
}
