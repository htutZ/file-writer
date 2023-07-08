export interface FileWriterPlugin {
  createDocument(options: FileWriterOptions): Promise<{ uri: string }>;
  writeToFile(): Promise<void>;
}

export interface FileWriterOptions {
  fileName: string;
  fileContent: string;
}
