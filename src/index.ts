import { registerPlugin } from '@capacitor/core';

import type { FileWriterPlugin } from './definitions';

const FileWriter = registerPlugin<FileWriterPlugin>('FileWriter', {
  web: () => import('./web').then(m => new m.FileWriterWeb()),
});

export * from './definitions';
export { FileWriter };
