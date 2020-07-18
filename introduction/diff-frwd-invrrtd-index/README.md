# Forward and Inverted Indexes - Requirement based differences

So this is my first post in the series of #explainlikeimfive on Dev.to. You can read the original post [here](https://dev.to/bhatman/forward-and-inverted-indexes-requirement-based-differences-1m3e). I hope you guys find this useful.

In this article, we try to understand the use of Forward and Inverted Indexes based on different requirements. The article is not about why the forward indexes are better than inverted, or vice-versa. Because both of them serve different purposes/requirements as explained in the post.

### **Topics to be covered**
     * Definitions
     * Requirement 1 and using Forward Indexes
     * Requirement 2 and using Inverted Indexes

Note: Forward Indexes are heavily used in traditional SQL databases like B-tree, Hash Indexes etc. So if you have ever heard of "indexes" in databases then chances are it was referring to _forward indexes_. Whereas Inverted Index articles and documentation specifically mention _inverted index_.


So now moving to the question of the hour, what is the main difference between Traditional forward indexes and inverted indexes?
> Inverted Index stores the words as index and document name(s) as mapped reference(s).
Forward Index stores the document name as index and word(s) as mapped reference(s).

But Ritesh you told me that you will explain it like I am five ? Stop this gibberish now..

Okay, let me give you real-world examples of forward and Inverted Index which we all see in our daily lives.

So I have this book with me "Team of Rivals", a great book written by Doris Kearns Goodwin about the political genius of Abraham Lincoln. Let's use this book to explain the difference between forward and reverse indexes.

![Alt Text](https://dev-to-uploads.s3.amazonaws.com/i/y5mxni0ijnw25d6au9m8.jpg)


**Requirement 1**: I know that I want to read the section "Show Down in Chicago" of the book, but I don't know which page it is on. 

So What how can I do this? How can I reach the "Show Down in Chicago" section of this 880 pages book?

**Approach 1 (Grepping)**: I will turn every page of the book from the beginning and check if it is the desired section. The technique is called _grepping_. But the section "Show Down in Chicago" is on page 237. So the number of checks required to reach the section will be ~237, and this is not acceptable because of the time and effort required in this.

**Approach 2 (Forward Indexes)**: Let's use Forward Indexes to solve this issue. You must have seen the first few pages which tell you about the exact location of the chapter/section, like this image.

![Alt Text](https://dev-to-uploads.s3.amazonaws.com/i/94ym46ikwgpzhoowiiin.png)

This is the actual idea of the working of forward indexes. Use a key(here chapter/section name) name to point to the specific record in the db (here starting of the content of the chapter int he book). So now the number of checks to reach the "Show Down in Chicago" gets reduced down to 1. Hence reducing the time and effort of our search. (It's not exactly 1 comparison but yes comparisons and time required in this approach are wayyyyyyyyy less than that of our approach 1 i.e grepping).

***
Now look at the next requirement related to a term search. 

**Requirement 2**: I want to search for all the documents which have mentioned the term "Baltimore" in the book. And let me remind you there are 880 pages in the book. And more than 300,000 words. Therefore grepping(aka scanning) in this case will require you to make 300,000 comparisons. This is enough to make any sane man go crazy. 

So how do we do this? How do we find all the pages which have mentioned "Baltimore"?

**Approach 1(grepping)**: You know the run, check each and every term of the book from start to end, and note down the page which has mentioned "Baltimore". Again very time consuming as already seen for the Requirement 1 too.

**Approach 2 (Inverted Indexes)**: Since we are talking about searching a term in a large collection of documents(aka collection of chapters in this case) we can use Inverted Indexes to solve this issue, and yes almost all books use these Inverted Indexes to make your life easier. Just like many other books "Team of Rivals" has inverted indexes at the end of the book as shown in this image.

![Alt Text](https://dev-to-uploads.s3.amazonaws.com/i/m40ibvqdoapeo68l80e2.jpg)

So after checking the Inverted indexes at the end of the book we know that "Baltimore" is mentioned on pages 629 and 630. So there are two parts in this _searching_ for "Baltimore" in the lexicographically ordered Inverted Index list and _fetching_ the pages based on the value of the index (here 629 and 630). The search time is very less for the term in the inverted index since in computing we actually use dictionaries(hash-based or search trees) to keep track of these terms and hence reduces down the search complexity from **O(n)** to **O(log n)** theoretically* when using the binary search or using a search tree, where **n** is the numbers of words/terms in our index. 

***

GIST: Forward Indexes are used to map a column's value to a row or group of records. Whereas Inverted Indexes are usually used to maps the words/terms/content of a large document to a list of articles.

There are many other differences but I don't want to go into too many jargon words/topics since this post is part of the #explainmelikeiamfive section. If you are interested in reading a lot more about the Inverted Index, you can follow this series [Inverted Index - The Story begins](https://dev.to/bhatman/inverted-index-the-story-begins-4l60) and the corresponding posts where the topics discussed will be more at intermediate and advanced levels.

You can read the same article on Gihub to on this link: [Forward Indexes and Inverted Indexes - Requirement based differences]()

***

Your feedbacks are most welcome and if you think something can be improved about this post please feel free to write that out in at riteshbhat17@gmail.com or leave a PR.
