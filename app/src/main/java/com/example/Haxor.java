package com.example;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * 	http://api.xposed.info/reference/de/robv/android/xposed/XC_MethodHook.MethodHookParam.html
 */
public class Haxor implements IXposedHookLoadPackage {

	/**
	 * The following can be found by decompiling an apk into java
	 *   OR
	 * Decompile an apk into smali code
	 * Note: Not all method names found in decompiled java can be hooked.
	 *       Use: "XposedHelpers.findClass(classToHook, lpparam.classLoader).getDeclaredMethods();"
	 *         to find all methods that can be hooked.
	 */
	final String packageName = "Package name of app";
	String classToHook = "Full class path prefixed by package name";
	String methodToHook = "Method name";

	public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
		if (!lpparam.packageName.equals(packageName)) return;

        // Parameters below are full class names of parameter types of the method that is being hooked
		// The five class parameters below are examples, do not use them
		findAndHookMethod(classToHook, lpparam.classLoader, methodToHook,
				"java.lang.String",
				"java.lang.String",
				"java.util.Map",
				"java.lang.String",
				"java.lang.String",
				new XC_MethodHook() {
					@Override
					protected void afterHookedMethod(MethodHookParam param) throws Throwable {
						super.afterHookedMethod(param);
						XposedBridge.log("Quman" + param.getResult().toString());
					}
				});
	}
}
