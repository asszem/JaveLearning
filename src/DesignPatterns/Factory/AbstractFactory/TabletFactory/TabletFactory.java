package DesignPatterns.Factory.AbstractFactory.TabletFactory;

import DesignPatterns.Factory.AbstractFactory.AbstractFactory;
import DesignPatterns.Factory.AbstractFactory.PhoneFactory.Huawei;
import DesignPatterns.Factory.AbstractFactory.PhoneFactory.IPhone;
import DesignPatterns.Factory.AbstractFactory.PhoneFactory.Phone;
import DesignPatterns.Factory.AbstractFactory.PhoneFactory.Samsung;

//This class provides a method to return a Tablet object based on the argument of getTablet method
public class TabletFactory extends AbstractFactory {

	public Tablet getTablet(String tabletType) {
		switch (tabletType.toLowerCase()) {
		case "ipad":
			return new iPad();
		case "nexus":
			return new Nexus();
		case "gpad":
			return new GPad();
		default:
			return null;
		}
	}

	@Override
	protected Phone getPhone(String phoneType) {
		return null;
	}

}