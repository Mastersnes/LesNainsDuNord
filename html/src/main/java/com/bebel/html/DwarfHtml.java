package com.bebel.html;

import com.bebel.core.Dwarf;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class DwarfHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Dwarf();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
