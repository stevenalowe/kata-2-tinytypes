STEP 6

How long did it take you to make that SKU validation change? How many lines of code did you have to write?

More importantly, how many lines of code did you have to read to find the place(s) to change?

(We typed about 5 lines of code in one place (Sku.validate) and added a unit test for a non-digit character Sku violation, too. The changes took a few minutes.)

Adding and testing serialization should have been just a few minutes' work also.

Thank you, TinyTypes!

ARE TINY TYPES RIGHT FOR YOUR PROJECT?

Now that you've seen how to construct TinyTypes and what they can do for you, perhaps you're wondering how to decide when to use a TinyType, and when not to?

Excellent questions!

When to Use a TinyType

If your object, regardless of how many fields it has, can or should never change, and is always used as the value of a variable or field, and represents a significant concept in the language of the domain, then a TinyType may be just the ticket to immutable freedom.

When NOT to Use a TinyType

If you are dealing with a data structure that has Identity other than its field values, you have an Entity and cannot use a TinyType...except when referencing the Entity in other contexts, if applicable. Suppose you have a User entity in your system, managed by the identity-and-permissions module. Inside that module, User is a full-blown Entity, able to be changed, stored, found, etc. That is all well and good. Now imagine that you need to reference a User in another area/module/context, perhaps as the author of a review of an item in your online store. In that context, is User still an Entity? No! In that context, the User is an immutable object, and you can use a TinyType to enforce that.

The short answer to the question "when to use a TinyType" is: when the object in question is an immutable value in your sphere of control (your "bounded context", to use the domain-driven design (DDD) term), you can use a TinyType to ensure immutability, consolidate validations, and treat it as an atomic value (a Value Object in DDD terms).