STEP 3

Extracting Market as a tinytype was similar to extracting Channel - the bits and pieces of Market name formatting were scattered around different classes, and now they're all in one validate method. Once again we found conflicting validation conditions, and our imaginary product manager confirmed the correct minimum/maximum lengths for a market's name.

We added null/invalid tests for Market; note that these tests, like those for Channel, are now testing the constructor, instead of a public API method (like LookUpItem).

Extract StyleCode similarly.
