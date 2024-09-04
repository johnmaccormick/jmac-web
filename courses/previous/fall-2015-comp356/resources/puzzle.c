#include "inttypes.h"
#include "stdio.h"

uint64_t mul(uint16_t a, uint16_t b)
{
    uint32_t c = a * b;
    return c;
}

int main()
{
  uint64_t val = mul(0xffff, 0xffff);
  printf("%x\n", val);
}
