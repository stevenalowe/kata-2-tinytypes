STEP 2

We had to muck around in all the code to find all of the relevant bits of the Channel tiny-type. Some of the validation was in DatabaseManager.FindChannel, and some was in InventoryRepo.LookUpItem, but we got it all assembled into a Channel.validate method, called by the Channel(name) constructor. Note that we found conflicting validation requirements - one place said a channel must be 5 characters, another said it must be 7 characters! We checked with our imaginary product manager, who verified that channel names must be at least 7 characters.

Now, while we can still create Channels that don't exist, we cannot create Channels that have names with invalid (or null) formats. Note that this not only make all the validation requirements of Channel easier to see, it also made the InventoryRepo and DatabaseManager classes a bit simpler.

It's worth taking a moment to talk about our Channel class. A few interesting features stand out:
- the class is marked as "final"; this prevents us (and everyone else) from creating subclasses of Channel. Since each Channel object represents a unique value from a finite set of values, and it has no behavior beyond construction, there is nothing to be gained from Channel subclasses; there's nothing interesting to inherit or override, and there are no additional behaviors that we might want to add.
- the name field is also marked as "final"; this prevents us from assigning a value to the name field more than once, which makes the name immutable. Once a Channel is created with a certain name, that name cannot be changed.
- every method of Channel is side-effect free, its state cannot be mutated, and (because of this) it is thread-safe. This is typically true of all Tiny Type objects (and Value Objects in general)
- the only public constructor requires all value arguments (name, in this case); the constructor either creates a valid, well-formed Channel object, or it throws an exception. It is thus impossible to create a Channel object with invalid state.
- we override the equals method (and by Java convention, hashCode also) so we can compare two Channel objects by their intrinsic value (i.e. their names) rather than by their object references (the default).

Now that we have liberated the Channel tiny-type from being mired in the primitive String swamp, we can see more clearly where Channels are used, and what constitutes a valid channel name.

While we were digging the pieces of the Channel type out of the distributed primitive muck, we realized we needed a more specific exception type for invalid channels, so we created one.

We also changed the InventoryItem constructor and fields, and also the InventoryRepo's item-lookup interface, which broke the unit tests. Note that while the compiler was still happy testing for a generic Exception, we changed our unit tests to expect a channel-specific exception.

We also had to change our unit tests to use Channel objects instead of strings, which required a @BeforeClass step instead of static String initialization. We also had to remove the 'final' qualifier from the validChannel static field to safely initialize it.

Even more fun though, was the realization that we no longer need the TestInvalidChannel method - because we cannot create an invalid Channel to pass to InventoryRepo.LookUpItem in the first place! Since LookUpItem can no longer be passed an invalid channel, its channel validation is unnecessary (plus it was moved to the Channel.validate method already). After a bit of thinking, and a discussion with our imaginary Solution Architect, we realized that it was extremely unlikely that LookUpItem could or would be passed a null Channel, since it would have to come from an uninitialized variable (which the compiler warns us about) or from a Channel variable accidentally reassigned to null (which is possible but highly unlikely in practice). We still have a null-channel unit test though, just in case; we don't want it to silently fail!

After re-running our altered tests, we see that TestNullChannel fails, but now it fails with a NullPointerException in DatabaseManager.FindChannel. That's good enough for our purposes, so we change the expected exception and go on.

One last thing: we notice that now we're not testing for InvalidChannelException at all, so we add two tests for that, one with a null channel name, and another with a channel name that is too short.

Extracting a tiny-type from existing code may touch a lot of places, but the result is worthwhile; try extracting a tiny-type for Market next.
