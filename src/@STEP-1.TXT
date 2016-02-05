Welcome to the Dojo!

Today we have an anti-pattern often called "primitive obsession" - everything is typed as primitives (Strings, integers, doubles et al), yet the primitive values clearly have structure and meaning beyond their base type.

Most of these are fairly simple names for things, e.g. Channel, Market, StyleCode. One of these is critical to modern retail inventory management: the Sku, or Stock-Keeping Unit.

From wikipedia (http://en.wikipedia.org/wiki/Stock_keeping_unit):

    "In the field of inventory management, a stock keeping unit or SKU is a distinct type of item for sale, such as a product or service, and all attributes associated with the item type that distinguish it from other item types. For a product, these attributes could include, but are not limited to, manufacturer, description, material, size, color, packaging, and warranty terms. When a business takes an inventory, it counts the quantity it has of each SKU."

Sounds much more important than a String, doesn't it?

Though we may "easily" represent a Market code, Style code, or Channel name as a string, these things have a range of valid values that is considerably smaller than "every possible String".

More importantly, these things have meaning in our business domain beyond a mere "sequence of characters".

What happens if we take these seemingly simple values and elevate them to the status of a type? In other words, what happens if we create a "tiny" type (a kind of "value object") for each of these, and use them instead?

The first thing that will happen is: the intent of our code will get much more clear.
The second thing that will happen is: all of our validation will be consolidated in one place per 'tiny' type.

That's a good thing, because I heard we're going to be changing the format of our SKUs soon!

First, let's review the definition of a value object:
    (from http://en.wikipedia.org/wiki/Value_object)
    "In computer science, a value object is a small object that represents a simple entity whose equality is not based on identity: i.e. two value objects are equal when they have the same value, not necessarily being the same object."
    "Value objects should be immutable: this is required for the implicit contract that two value objects created equal, should remain equal. It is also useful for value objects to be immutable, as client code cannot put the value object in an invalid state or introduce buggy behaviour after instantiation."

So, we want to create and use immutable values of a specific type; once created they cannot be changed, and they have no identity other than their value. That sounds useful, but is it?

Let's find out. This kata is a bit more exploratory than the others, in that we don't have a specific goal state in mind that we are trying to reach via refactoring; instead, we are refactoring to isolate the semantics of some prospective value types, to see if doing so proves useful. (Hint: it will!)

To get started, create classes for each value type. Remember to override the equals (and getHashcode) method, create the objects with their (immutable) value in the constructor, and do not provide any way to change the value of the object after it is created.

Hints:
- look at every place in the code where the value is used, validated, and/or created; pull all of the 'moving parts' into your class
- override the equals and getHashcode methods, for proper comparison of value objects
- make the class final
- make all fields private and final, set only in the constructor
- don't provide a no-arg constructor or field-setters
- validate the initial value in the constructor, and throw a specialized exception if it's invalid
- see http://www.javapractices.com/topic/TopicAction.do?Id=29 for more about immutable objects

Go create a Tiny Type for Channel first, to see what happens.
