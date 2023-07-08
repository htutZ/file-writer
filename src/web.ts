// src/web.ts

import { WebPlugin } from '@capacitor/core';
import { FileWriterPlugin } from './definitions';

export class FileWriterWeb extends WebPlugin implements FileWriterPlugin {
  constructor() {
    super({
      name: 'FileWriter'
    });
  }
  echo(): Promise<{ value: string; }> {
    throw new Error('Method not implemented.');
  }
  writeToFile(): Promise<void> {
    throw new Error('Method not implemented.');
  }

  async createDocument(_options: { fileName: string; fileContent: string; }): Promise<{ uri: string; }> {
    return { uri: '' };
  }
}

const FileWriter = new FileWriterWeb();

export { FileWriter };

import { registerPlugin } from '@capacitor/core';
registerPlugin('FileWriter', FileWriter);
