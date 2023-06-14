import { WebPlugin } from '@capacitor/core';

import type { FileWriterPlugin } from './definitions';

export class FileWriterWeb extends WebPlugin implements FileWriterPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
