/** 
 * Interface Transformable
 * Author: Georg Hubinger 9947673 
 */
public interface Transformable {
	/**
	 * Clone Object and rotate the clone
	 * @param alpha Angle to rotate against origin
	 */
	public Transformable rotate2(double alpha);
	
	/**
	 * Clone Object and move the clone
	 * @param tx distance to move Object along x-axis
	 * @param ty distance to move Object along y-axis
	 */
	public Transformable move2(double tx, double ty);

	/**
	 * Clone Object and rotate the clone
	 * @param sx value to scale Object along x-axis
	 * @param sy value to scale Object along y-axis
	 */
	public Transformable scale2(double sx, double sy);
	
}
