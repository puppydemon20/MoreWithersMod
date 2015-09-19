package com.puppydemon.MoreWithersMod.augments;

import com.puppydemon.MoreWithersMod.item.ItemMWM;
import com.puppydemon.MoreWithersMod.reference.AugmentReference;

public class AugmentTest extends ItemMWM
{
	public AugmentTest()
	{
		super();
		this.setUnlocalizedName("AugmentTest");
	}
	
	private Object Ability () 
	{
	return AugmentReference.STRENGTH;
	}
}