# Usage Instructions #

## Requirements ##

- Need to have Android device jailbroken
- Need to have Xposed installed

## Installation ##

- Open project in Android Studio
- Change package name, class name, and method name to represent what you want to hook
- Run project
- Open Xposed on your phone, enable the module, reboot your phone
- When that method that you hooked gets called, it should just work
- Log out info you want logged using XposedBridge.log()

## Additional Info ##

- This can hook any method from any app on your android device
- Can decompile app using apktool and [smali](https://github.com/JesusFreke/smali)
- Look through the smali code to find the method you want and use its parameters
- Can also use [apk decompiler](http://www.javadecompilers.com/apk) to decompile apk into java. However, not all methods will be availiable to hook and parameter names will not be complete which is not the end of the world, but something to be aware of since you need to pass full parameter types to Xposed
- Checkout the [Xposed docs](http://api.xposed.info/reference/packages.html) docs for more info on what you can do with the framework. It includes:
  * View input of methods
  * View output of methods
  * Modify input of methods
  * Modify output of methods
  * etc
- A cool small example is to modify the system UI of the homescreen. Start by running "adb shell pm list packages" inside your terminal when your phone is connected via USB.
