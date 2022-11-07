Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
I decided to overload the constructors because I didn't feel there was any reason to overload any of the methods since they pretty much just need to take a single value with a single type. The constructors, however, are more practical to overload since they take many types of data, some of which don't really apply to their subclass. For instance, it doesn't really make sense to need to specify how many floors a Cafe has if the default answer is one. I made the following overloaded constructors following the same reason. 

    Library: 
        If you don't enter elevator status, it assumes elevator-false.
        If you don't enter floor status, set to 1.
    Cafe: 
        If elevator status not mentioned, elevator=false. If floor number not specified, nFloors=1
        If elevator status not mentioned, elevator=false
    House:
        If nFloors wasn't specified then set nFloors to 1
        If hasDR wasn't specified then set hasDR to true.
        If elevator not set, then elevator=false.

- What worked, what didn't, what advice would you give someone taking this course in the future?

In this case I personally don't think overloading is super worth it because you add a ton of repeated lines of code just for a small amount of flexibility in how the user can create the subclasses, but I do see how overloading has the potential to be very useful given a larger application with methods or constructors that make sense to take different types. I wish there was a way to reference the "original" constructor when you're making an overloaded one so you don't have to just copy paste it each time when you only want to add one extra line.