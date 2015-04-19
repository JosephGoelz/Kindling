##CSCI 201 Team Project Repository

###Contact Information
**Developer 1**:
  + Name: Trevor Cai
  + USC Email: tcai@usc.edu
  + Lecture Section: 30393

**Developer 2**:
  + Name: Joseph D. Goelz
  + USC Email: jgoelz@usc.edu
  + Lecture Section: 30381

**Developer 3**:
  + Name: Taegyum Kim
  + USC Email: taegyumk@usc.edu
  + Lecture Section: 30381

**Developer 4**:
  + Name: Winston Lee
  + USC Email: winstojl@usc.edu
  + Lecture Section: 30381

**Developer 5**:
  + Name: Joyce Yan
  + USC Email: joyceyan@usc.edu
  + Lecture Section: 30381

###Git Best Practices

Before you start working, checkout to a new branch. Remember to commit regularly!
```
git checkout -b my-feature
git commit -m "i made a change!"
git commit -m "here's another change!"
git commit -m "i commit regularly to properly utilize the advantages of distributed version control!"
```

If someone has pushed to master and you want their changes for your feature before you push onto master yourself, then pull from master and merge master onto your branch.
```
git checkout master
git pull
git checkout my-feature
git merge master
```

When you are ready to deploy your feature, commit all your changes and run a git status to double check that all your changes are in. Then, checkout to master (and git pull to make sure you're up to date) and merge changes from your branch onto master. After your changes are properly merged from your local branch to your local copy of master, push from your local copy of master to the remote master.
```
git commit -m "here's my final change!"
git checkout master
git pull
git merge my-feature
git push
```

If you run into a merge conflict, run a "git status" to see which files have a conflict. Then, open these files directly, and manually merge the changes you want to see. When you are done, save the file, git add it, and then I forgot what you do after this, so cry or something.
```
git status

These files have a conflict:
asdf.txt

git add asdf.txt
????
```
