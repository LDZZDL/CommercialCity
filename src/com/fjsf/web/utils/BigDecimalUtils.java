package com.fjsf.web.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {
	
	static public BigDecimal changeIntToBigDecimal(Integer val){
		return new BigDecimal(val);
	}
	
	static public BigDecimal changeDoubleToBigDecimal(Double val){
		return new BigDecimal(val);
	}
	
	static public Double getResultAdd(BigDecimal a, BigDecimal b){
		return a.add(b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	static public Double getResultSub(BigDecimal a, BigDecimal b){
		return a.subtract(b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	static public Double getResultMul(BigDecimal a, BigDecimal b){
		return a.multiply(b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	static public Double getResultAdd(Double a, Double b){
		BigDecimal A = changeDoubleToBigDecimal(a);
		BigDecimal B = changeDoubleToBigDecimal(b);
		return A.add(B).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	static public Double getResultSub(Double a, Double b){
		BigDecimal A = changeDoubleToBigDecimal(a);
		BigDecimal B = changeDoubleToBigDecimal(b);
		return A.subtract(B).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	static public Double getResultMul(Double a, Integer b){
		BigDecimal A = changeDoubleToBigDecimal(a);
		BigDecimal B = changeIntToBigDecimal(b);
		return A.multiply(B).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
