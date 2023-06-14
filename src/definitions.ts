export interface FileWriterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
