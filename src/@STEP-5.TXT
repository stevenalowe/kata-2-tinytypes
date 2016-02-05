STEP 5

Extracting Sku as a tinytype was similar to extracting the others. Katas do involve some repetition!

The next time you start to use Strings as fields in your data model, will you take a moment to consider using a TinyType instead?

Let's take another look at our InventoryItem class - all of the fields except Description are immutable TinyTypes; these field values will never change, and resetting e.g. the Channel of an inventory item should generate a new, different InventoryItem. In other words, we've realized that in our bounded context, InventoryItem is immutable; created once, and never updated. So we can get rid of the no-arg constructor and all of the set-methods.

I know, some data-access layers/mechanisms require no-arg constructors and getters and setters, and I think that's ugly. Perhaps less ugly than requiring a mediation or data-transfer object (which is cumbersome, to say the least), but Java has had reflection for a long time. So we imagine/conclude that we don't need these things, and are left with a much simpler, immutable, thread-safe InventoryItem class.

Excuse me a moment, our imaginary Iteration Manager is trying to tell me something...

...oh my, it seems that the rumors were true, and we're going to have to change the SKU format. The third character must be a digit, and a SKU can now be up to 16 characters long. Oh, and make sure that InventoryItem and all the Tiny Types are serializable.

Everyone else is upset; they know that SKUs are used everywhere in this system! The rest of the team is talking nervously about how to attack this problem - they're worried because SKUs are just strings with validations all over the place...

...except in your area (yay for bounded contexts!), where the validation change is trivial, thanks to the Power of TinyTypes!

Go ahead and make that change now: the third character of a SKU must be a digit, and max length is now 16. As for serializing a Tiny Type, here's a hint: http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html. Include a unit test for serialization.
