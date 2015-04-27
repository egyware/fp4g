animatorState = {}

function animatorState.new (entity, action)
   local self = {}
   self.sprite   = entity.SpriteBehavior
   self.animator = entity.AnimatorBehavior
   self.enter    = action
   return self
end