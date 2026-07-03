# jmac-web

Public web content for John MacCormick

## Partial clone instructions


```bash
git clone --depth=1 --filter=blob:none --no-checkout https://github.com/johnmaccormick/jmac-web.git jmac-web-sparse
cd jmac-web-sparse
git sparse-checkout init --no-cone
git sparse-checkout set README.md bookmarks.md bookmarks/
git checkout
```

After this, you can add more files to the sparse checkout with `git sparse-checkout add <file>`.