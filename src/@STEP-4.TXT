STEP 4

Extracting StyleCode as a tinytype was similar to extracting Channel and Market. Don't you wish the original developers had done this to start with, instead of spreading validation rules around the code inconsistently?

Again we added null/invalid tests for StyleCode, targeting the constructor.

Do we want to extract Description? We could argue that since 'description' means more than just String and also (presumably) has formatting constraints (i.e. not just any string of any size) that it is, in fact, a de-facto type and we should formalize this.

We choose not to, in this case, for two reasons:
- extracting Description would be just like extracting Channel, Market, and StyleCode, but simpler because it has no validation other than non-null at present. So it wouldn't be very interesting and would just make the kata longer.
- extracting Sku is more interesting, and we want to get to that

Extract a tiny-type for Sku next, then we'll wrap it up.

