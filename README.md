# file-writer

Access Documents Directory

## Install

```bash
npm install file-writer
npx cap sync
```

## API

<docgen-index>

* [`createDocument(...)`](#createdocument)
* [`writeToFile()`](#writetofile)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### createDocument(...)

```typescript
createDocument(options: FileWriterOptions) => Promise<{ uri: string; }>
```

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#filewriteroptions">FileWriterOptions</a></code> |

**Returns:** <code>Promise&lt;{ uri: string; }&gt;</code>

--------------------


### writeToFile()

```typescript
writeToFile() => Promise<void>
```

--------------------


### Interfaces


#### FileWriterOptions

| Prop              | Type                |
| ----------------- | ------------------- |
| **`fileName`**    | <code>string</code> |
| **`fileContent`** | <code>string</code> |

</docgen-api>
