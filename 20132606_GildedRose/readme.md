Participants:
============
* Axel
* Alex
* Juan
* Guillaume

Topic
=====
See topic.md

Retrospective:
=============
General perspective
-------------------
* First dojo at Fabelier !
* It's been mainly a success: we had no major organizational issue, and attendance seemed rather interested
* However: it lasted nearly 2 hours. We stopped because we started to saturate a bit. We may'd rather want to do shorter sessions next times
* Even if the dojo was rather short, we used Git to save intermediate steps. We may have wanted to commit more often, to be able to review the steps we took afterward.

Regarding the topic itself
--------------------------
* We started doing a general end to end test, then a few more specific unit tests, before touching the main code. Hence, when we started refactoring, we had a safety net. However, we didn't took the time to write tests for each specific rules since we didn't want to spend most of the dojo writting tests before starting to refactor.
* We naturally ended up doing several small refactorings rather than thinking of a big new design. It's been quite reassuring to be able to compile and play the tests quite often. And when they once failed, it's been quite easy and fast to undo what we just made
* Consequently, we didn't do any OO programming. If we had more time we may have ended introducing acutal objects. In particular, at the end, we started to feel we could naturally subclass the Item class, introducing one class per type of item, and to use the behavior pattern to implement the different types of quality decrease. It seems it could have been a natural extension of what we did, since methods we extracted felt like they could have been moved more or less as-is, in such behavior
* We completely forgot the feature we were supposed to add, because we only focused on refactoring... however, I think we ended up with a much cleaner code! (still ugly, but much cleaner!)

Conclusion
=========
If we try again we should:
* commit more often, to give a chronological view of the session
* do shorted sessions, like 1h30.
