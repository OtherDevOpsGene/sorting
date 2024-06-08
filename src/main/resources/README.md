# words

The word lists are sourced from
https://github.com/hermitdave/FrequencyWords.git, stripped of frequency counts
and filtered for only 3+ letter words with only letters.

```sh
cat en_full.txt | awk '{ print $1; }' | grep -x -E '^[a-z]{3,}$' src/main/resources/words.txt
```

# License

The original word list comes from
https://github.com/hermitdave/FrequencyWords.git, 
and is used via [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0/). 

The filtered lists are free to use under the same license.
