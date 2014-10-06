Android structure

-Linux based system
-Kernel(drivers, controllers) -> Libraries(basic libraries to connect with the drivers) Also Android Runtime (Libraries and Dalvik VM) -> APP Framework (Activity Manager, Package Manager), APP`s

Kernel ->lowest level, drivers
Libraries-> Written in C or C++ are the native libraries that "translate" the code for the phone architecture
Android Runtime -> Each app run in unique virtual machine, this virtual machine is optimized to run programs written in Java to mobile
APP framework -> What is used to build the applications, provide a lot of resources
Applications -> It is what the end-user see


Application are seen by the system as a user and each application has one user Id. To this Id is possible to give permission to others applications use it. So the secutiry is given by if the app that is trying to access is in the list of apps that have permission


Activity - every screen on the android is a activity. An app can have 1 or more activities and the program run inside of the activity.
Intend - when a activity needs to use others resource or itself resource, the activity provides a bunch of information about what it is trying to open and others that are convenient for the application. Intend is like a sender. It can start others activity of others applications (if they have permission), so it`s possible to re-use the application built for others instead of built another one. 
Service - Tasks that run in the background, can be along with the activity or can still work even if the activity is closed.
Content Providers - provide a group of information when asked

Life cycle

Start [onCreate(); onStart(); onResume(); onRestoreInstance()] --> Running
Running [onPause(); onSaveInstanceState();] --->Paused
Paused [onResume();] --> Running
Paused [onSaveInstanceState(); onStop();] --> Stopped
Paused ---> Process Kill
Stopped [onResume(); onStart(); onRestart();] --->Running
Stopped [onDestroy(); Process Kill] --->Running

Building the program
After create a project
folder -> src (where the source code in java gonna be)
	  res (where the xml files gonna be)
	  gen (generate by the system, it is where "R" is. R is a generated file where all the references of my application are)

xml files -> Allow us to build only one code for different sizes of screen. All of the layout of the activites are written here. They can have different kind of layouts.
	Relative Layout -> The elements can be organized as the wish of the developer
	Linear Layout -> the elements are put one above other.(Good for menu). The elements have lots of paramenter that can be set. --Text field, buttons ... ---.
Others xml files can be used to save values as strings, arrays, colors, folder address ... So when is necessary to be used just call their variables.
The ANDROID MANIFEST is extremely important because it is the reason why the android can see the applications that can be used. Even if we create dozen of activities but don`t say to the system by the manifest that they exist the application will not work saying that has no reference for that activity. The ANDROID MANIFEST is also responsible for have all the information about the application. 

java files -> The activities layout aren`t useful if they doesn`t have programmable functions. The java codes give soul to the body (layout). The application need at least one code that extends Activity. This new activity created will require a layout. Just have to choose the layout created for the application. Events to analise if any button was pressed can be used, too. The activity can open other activity or call of the activity for another application and receive data from this application using Intend passing the information necessary.

