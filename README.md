# kata-2-tinytypes
Refactoring primitives (Strings, in this case) into small/simple value types aka "Tiny Types".

In this kata, we'll take a slice of code from an inventory system that is infested with Strings, and refactor it to use TinyTypes instead.

# But Why???

Why go to all the trouble of making a class for something so simple it can be represented directly as a String? An excellent question! There are several reasons, but the most important one is:
 
  * to expose the underlying Domain concept; to make it explicit in the code as a type, instead of implicit in a parameter name
  
This may seem like a small thing, and it is - but it has long-term beneficial effects on the code base:

  * mechanically, all of the validation and formatting that is currently spread around the code will be consolidated into a single class
  * semantically, using the Domain concept as a type makes the "ubiquitous langauge" - the business-domain language - explicit in the code
  
The latter aids in understanding what the code is doing from a business-effects perspective, while the former simplifies code maintenance and contributes to easier understanding of the code.

### For example, which method signature is easier to immediately understand?

  1. String reserveInventory(String, String, String, Integer), or
  2. InventoryReservation reserveInventory(Channel, Market, Sku, Quantity)?
  
The meaning of the second method is much more obvious than the first; it makes more sense because it uses the language of the business domain, instead of the implementation domain. That is the power of Tiny Types!

##Instructions for Using this Repo

To keep the scope of our changes small, we focus on one refactoring step at a time, supported by unit tests (provided).

Each step is captured in a branch, so you can play with the code and then compare your results with ours, compare the branches to each other, etc. Each branch has an instruction file (@STEP-N.TXT) on what we're trying to accomplish for the next step.

To use this repo, clone it locally. It should "just work" if you open it using IntelliJ IDEA. If you're using Eclipse, you'll have to import it into your workspace:

    File > Import > General > Existing Projects into Workspace
    then choose the kata's root directory

Notes: 

  * after you change branches (see step 2 below) you may need to refresh the eclipse project (right-click > Refresh). IntelliJ seems to do this automatically.
  * the first time you open the project in IntelliJ, it may complain about "Unregistered VCS root detected", if so just click 'Ignore'

The only dependency is on JUnit, which should be handled by the IntelliJ/Eclipse project files already.

The unit test suite is named TestGenerateFlatRecordFromShopEvent, and the main class we are refactoring is named GenerateFlatRecordForShopEvent.

Note: IntelliJ may complain about "Unregistered VCS root detected", if so just click 'Ignore'.

This repo includes eight branches, starting with the original code and progressing through each change step. Start with the original code branch (see below) and follow the @STEP-1.TXT instructions to modify it as suggested. Then compare your results to the next branch, and so on, until the end.
 
###Example:

    1. clone the repo locally:

```
        git clone https://github.com/.../kata-2-tinytypes.git
```

    2. CD to the source directory and switch to the first branch, named STEP-1 (yes, uppercase matters)
    
```
        cd kata-2-tinytypes
        git checkout STEP-1
```

    3. make sure the code builds and the unit tests pass (JUnit is the only dependency, v4.12)
    4. read the instructions for each step (e.g. @STEP-1.TXT in this case)
    5. modify the code as instructed
    6. run the unit tests (make them pass if they fail; kudos if you refactored carefully enough to not break the tests!)
    7. OPTIONAL BUT FUN: compare your changes to the next branch
    
```
        git diff STEP-1..STEP-2
```

    8. switch to the next branch (named STEP-2, STEP-3, ..., STEP-6) and repeat from #2 above
       NOTE: if you've made changes, git will whine at you when you try to switch branches; 
             commit or stash your changes to make it shut up
    9. PROFIT! (metaphorically)

##Goals
The technical goal of this exercise is to refactor this:

```Java
public class InventoryRepo {
    public InventoryItem LookUpItem(String channel, String market, String styleCode, String description) { ... }

    public InventoryItem LookUpItem(String sku) { ... }
}
```

into this:

```Java
public class InventoryRepo {
    public InventoryItem LookUpItem(Channel channel, Market market, StyleCode styleCode, String description) { ... }

    public InventoryItem LookUpItem(Sku sku) { ... }
}
```

The learning goals are:

  1. get familiar with simple type classes aka "tiny types"
  2. see how they consolidate validation and simplify interactions,
  3. show how they help spread the "ubiquitous language" through the code

##Roadmap

We will do this in 5 small, repetitive, incremental steps:

    1. extract a tiny type for Channel
        To see how and where we have to dig to find validation conditions, and how it cleans all that up 
        
    2. extract a tiny type for Market
        It's a kata, there's bound to be some repetition

    3. extract a tiny type for StyleCode
        It's a kata, there's bound to be some repetition

    4. extract a tiny type for SKU
        It's a kata, there's bound to be some repetition

    5. change SKU format/validation
        Unlock the power of TinyTypes!
    
##*Suggestions for improvements are always welcome!*

Please [take the survey](https://www.surveymonkey.com/r/DPYTVHQ) when done so we can keep making this better!

--Steven

slowe@thoughtworks.com
